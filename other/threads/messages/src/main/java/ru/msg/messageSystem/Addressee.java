package ru.msg.messageSystem;

/**
 * Our addressee
 */
public interface Addressee {
    //addressee has address,it is convenient to send a response message
    Address getAddress();

    MessageSystem getMS();
}
