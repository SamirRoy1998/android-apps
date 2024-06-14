package com.example.practice

class Storage {
    val list = generateDataList()

    private fun generateDataList(): List<Data> {
        val dataList = mutableListOf<Data>()
        val names = listOf("Samir", "Amir", "Rohan", "Aisha", "Arjun", "Priya", "Vikram", "Anjali", "Karan", "Neha", "Ravi", "Divya", "Nisha", "Rahul", "Suman", "Raj", "Sneha", "Mohan", "Pooja", "Tarun", "Sunita", "Ajay", "Ritu", "Ashok", "Kavita", "Manoj", "Geeta", "Anil", "Sita", "Deepak", "Rina", "Vijay", "Swati", "Narendra", "Pankaj", "Meena", "Suresh", "Lata", "Gopal", "Shweta", "Ankit", "Komal", "Naveen", "Amit", "Parul", "Rakesh", "Madhuri", "Hari", "Rekha")
        val numbers = listOf("8486521693", "8486589412", "7800560071", "9214567890", "9801234567", "9907654321", "9123456789", "9823456789", "9812345678", "9834567890", "9845678901", "9856789012", "9867890123", "9878901234", "9889012345", "9890123456", "9812345670", "9823456701", "9834567012", "9845670123", "9856781234", "9867892345", "9878903456", "9889014567", "9890125678", "9812346789", "9823457890", "9834568901", "9845679012", "9856780123", "9867891234", "9878902345", "9889013456", "9890124567", "9812347890", "9823458901", "9834569012", "9845670124", "9856781235", "9867892346", "9878903457", "9889014568", "9890125679", "9812346781", "9823457892", "9834568903", "9845679014", "9856780125", "9867891236")

        for (i in 1..5000) {
            val name = names[i % names.size]
            val number = numbers[i % numbers.size]
            dataList.add(Data(name, number))
        }
        return dataList
    }
}
