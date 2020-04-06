package com.ercargo.agent;


import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author ercargo  on 2020/4/5
 * @DESCRIBE
 */
public class Attacher {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {

        // 该 pid 从 运行的 Base 进程中获取
        VirtualMachine vm = VirtualMachine.attach("73738");
        vm.loadAgent("/Users/ercargo/ErCargo/concurrency/app.jar");
    }
}
