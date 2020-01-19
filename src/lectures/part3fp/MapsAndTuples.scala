package lectures.part3fp

object MapsAndTuples extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "hello, Scala")  // Tuple2[Int, String] = (Int, String)

  println(aTuple._1)  // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)  // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1)
  // a -> b is sugar for (a, b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functions on maps
  // filter, map, flatmap

  println(newPhonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phonebook.mapValues(number => "0245-" + number))
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))


  var newPhnbk = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1)
  println(newPhnbk.map(contact => contact._1.toLowerCase -> contact._2))

  /*
    1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
        !!! careful with mapping keys.
    2.  Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend
        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between two people (direct or not)
   */

  def add(network:Map[String,Set[String]], person:String): Map[String,Set[String]] =
    network + (person -> Set())

  def addFriend(network:Map[String,Set[String]], a:String, b:String): Map[String,Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unFriend(network:Map[String,Set[String]], a:String, b:String): Map[String,Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def removePerson(network:Map[String,Set[String]], person:String): Map[String,Set[String]] = {
    // before removing the person we need to get his friend list and unfriend him from all the friends
    def removeAux(friends:Set[String], auxNetwork:Map[String, Set[String]]) : Map[String, Set[String]] = {
      if (friends.isEmpty) auxNetwork
      else removeAux(friends.tail, unFriend(auxNetwork,person,friends.head))
    }
    val removedFriends = removeAux(network(person), network)
    removedFriends - person
  }

  val empty : Map[String,Set[String]] = Map()
  val network = add(add(add(add(empty,"Sahil"), "Aastha"), "Chotu"),"Random")
  println(network)
  val newNetwork = addFriend(addFriend(network, "Sahil","Chotu"), "Sahil","Aastha")


//  val updatedNetwork = unFriend(newNetwork, "Sahil", "Aastha")
//  println(updatedNetwork)
//  val finalNetwork = removePerson(updatedNetwork,"Sahil")
//  println(finalNetwork)

  // calc number of friends of a given person

  def calcFriends(network:Map[String,Set[String]], person:String) : Int =
    network(person).size

  println(calcFriends(newNetwork,"Sahil"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(newNetwork))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    println(newNetwork.filter(value => value._2.isEmpty))
    newNetwork.filter(value => value._2.isEmpty).size
  }

  println(nPeopleWithNoFriends(newNetwork))

}
