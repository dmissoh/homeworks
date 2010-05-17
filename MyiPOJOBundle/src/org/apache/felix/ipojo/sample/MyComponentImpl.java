package org.apache.felix.ipojo.sample;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Validate;

@Component
public class MyComponentImpl {
    
    @Validate
    public void start() {
        System.out.println("I'm started !!!");
    }
    
    @Invalidate
    public void stop() {
        System.out.println("I'm leaving :-(...");
    }
    

}
