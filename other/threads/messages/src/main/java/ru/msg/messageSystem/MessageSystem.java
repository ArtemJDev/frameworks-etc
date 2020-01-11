package ru.msg.messageSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class MessageSystem {
    private static final int DEFAULT_STEP_TIME = 10;

    /**
     * List of threads to work so that they can stop by dispose method
     */
    private final List<Thread> workers;
    /**
     * Map - according to the address puts a message
     */
    private final Map<Address, ConcurrentLinkedQueue<Message>> messagesMap;
    /**
     * Map - according to the address and addressee
     */
    private final Map<Address, Addressee> addresseeMap;

    public MessageSystem() {
        workers = new ArrayList<>();
        messagesMap = new HashMap<>();
        addresseeMap = new HashMap<>();
    }

    public void addAddressee(Addressee addressee) {
        addresseeMap.put(addressee.getAddress(), addressee);
        messagesMap.put(addressee.getAddress(), new ConcurrentLinkedQueue<>());
    }

    public void sendMessage(Message message) {
        messagesMap.get(message.getTo()).add(message);
    }

    /**
     * For each addressee we start a thread and in it an infinite loop
     * for receiving and responding to messages
     */
    public void start() {
        for (Map.Entry<Address, Addressee> entry : addresseeMap.entrySet()) {
            String name = "MS-worker-" + entry.getKey().getId();
            Thread thread = new Thread(() -> {
                while (true) {

                    ConcurrentLinkedQueue<Message> queue = messagesMap.get(entry.getKey());
                    while (!queue.isEmpty()) {
                        Message message = queue.poll();
                        message.exec(entry.getValue());
                    }
                    try {
                        Thread.sleep(MessageSystem.DEFAULT_STEP_TIME);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted. Finishing: " + name);
                        return;
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Finishing: " + name);
                        return;
                    }
                }
            });
            thread.setName(name);
            thread.start();
            workers.add(thread);
        }
    }

    public void dispose() {
        workers.forEach(Thread::interrupt);
    }
}
