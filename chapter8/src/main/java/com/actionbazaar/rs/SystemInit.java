/**
 *  SystemInit.java
 *  EJB 3 in Action
 *  Book: http://manning.com/panda2/
 *  Code: http://code.google.com/p/action-bazaar/
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.actionbazaar.rs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.ws.rs.core.Application;

/**
 * Initializes the JAX-RS
 */
public class SystemInit extends Application {
    
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger("SystemInit");
    
    @Override
    public Set<Class<?>> getClasses() {
        return Collections.emptySet();
    }
    
    @Override
    public Set<Object> getSingletons() {
        Set<Object> classes = new HashSet<Object>();
        try {
            InitialContext ctx = new InitialContext();
            Object bidServiceRS = 
              ctx.lookup("java:global/WebServiceExperiment/BidService");
            classes.add(bidServiceRS);
        } catch (Throwable t) {
            logger.log(Level.SEVERE,"Error: ",t);
        }
        return classes;
    }  
}

