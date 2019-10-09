/*
    File Description: starts and stops interpreter and stops socket
*/

import java.net.Socket

object ConnectionManager {
    private val sockets: MutableMap<ChatConnector, Socket> = mutableMapOf()
    private val threads: MutableMap<ChatConnector, Thread> = mutableMapOf()


    @Synchronized
    fun start(interpreter: ChatConnector, socket: Socket) {  //start command interpreter
        val thread = Thread(interpreter)
        threads.put(interpreter, thread)
        sockets.put(interpreter, socket)
        thread.start()
    }

    @Synchronized
    fun terminate(commandInterpreter: ChatConnector) {
        closeSocket(commandInterpreter)
        stopThread(commandInterpreter)
    }

    private fun stopThread(commandInterpreter: ChatConnector) { //stop command interpreter
        val thread = threads.get(commandInterpreter)
        if (thread != null) {
            thread.interrupt()
            threads.remove(commandInterpreter)
        }
    }

    private fun closeSocket(commandInterpreter: ChatConnector) {
        val socket = sockets.get(commandInterpreter)
        if (socket != null) {
            socket.close()
            if (socket.inetAddress != null) println("${socket.inetAddress.hostAddress} connection closed") // used for unit test
            sockets.remove(commandInterpreter)
        }
    }

    //for unit test
    @Synchronized
    fun isRunning(interpreter: ChatConnector) = threads.containsKey(interpreter)

    @Synchronized
    fun clean() = {
        sockets.clear()
        threads.clear()
    }
}
