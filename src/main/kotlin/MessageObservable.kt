/*  
    File Description: observerable interface, defines four methods to methods, to be implemented by inherited class
*/

interface MessageObservable {
    fun register(observer: MessageObserver)
    //methods to register and unregister observers

    fun unregister(observer: MessageObserver)


    //method to notify observers of change
    fun notifyObservers(chatMessage: ChatConsole)

    //method to notify observers of change in one specific chatgroup
    fun notifyObservers(message: ChatConsole, group: String)
}
