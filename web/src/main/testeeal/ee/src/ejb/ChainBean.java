package main.testeeal.ee.src.ejb;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@DependsOn("ChainBeanSecond")
public class ChainBean {

}
