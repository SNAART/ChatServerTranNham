fun main(args: Array<String>) {

    val server = ChatServer()
    server.createLocalPortAndEstablishCommunication()
    //call method in ChatServer class to start server and establish connection
}
