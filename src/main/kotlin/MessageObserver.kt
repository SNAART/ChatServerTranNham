/*  
    File Description: observer interface, defines three methods
    to be inherited by command interpreter class, methods to be implemented in command interpreter
*/


interface MessageObserver {
    fun incomingMessage(message: ChatConsole)
    fun getUsername():String
    fun incomingGroupMessage(group: String, message: ChatConsole)
    fun incomingPrivateMessage(userName:String, message: ChatConsole)

}
