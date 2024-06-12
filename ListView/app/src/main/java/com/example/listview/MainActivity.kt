package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_main)
        b.mainLayout = this
        ViewCompat.setOnApplyWindowInsetsListener(b.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data1 = arrayOf(
            "Samir",
            "Ram",
            "Harry",
            "Mohan",
            "Ganesh",
            "Krishna",
            "Joy",
            "John",
            "Subhash",
            "Rita",
            "Mohan",
            "Lily",
            "Sophia",
            "James",
            "David",
            "Peter",
            "Nancy",
            "Julia",
            "Victor",
            "Olivia",
            "Emma",
            "Amit",
            "Neha",
            "Ravi",
            "Priya",
            "Anil",
            "Vijay",
            "Sara",
            "Manish",
            "Nitin",
            "Tina",
            "Raj",
            "Vikram",
            "Sneha",
            "Suman",
            "Yash",
            "Kavita",
            "Deepak",
            "Anita",
            "Pooja",
            "Karan",
            "Arjun",
            "Meena",
            "Farhan",
            "Aisha",
            "Isha",
            "Mira",
            "Sanjay",
            "Rakesh",
            "Suresh"
        )

        val data2 = arrayOf(
            Person("Samir", 451, 25),
            Person("Ram", 487, 26),
            Person("Harry", 489, 28),
            Person("Mohan", 457, 26),
            Person("Ganesh", 477, 29),
            Person("Krishna", 587, 23),
            Person("Joy", 687, 26),
            Person("John", 887, 36),
            Person("Subhash", 387, 46),
            Person("Rita", 887, 20),
            Person("Mohan", 557, 26),
            Person("Lily", 431, 22),
            Person("Sophia", 429, 24),
            Person("James", 473, 27),
            Person("David", 529, 30),
            Person("Peter", 603, 33),
            Person("Nancy", 702, 25),
            Person("Julia", 829, 26),
            Person("Victor", 912, 28),
            Person("Olivia", 721, 22),
            Person("Emma", 658, 21),
            Person("Amit", 494, 27),
            Person("Neha", 715, 23),
            Person("Ravi", 538, 28),
            Person("Priya", 621, 29),
            Person("Anil", 472, 32),
            Person("Vijay", 559, 24),
            Person("Sara", 683, 25),
            Person("Manish", 765, 31),
            Person("Nitin", 844, 27),
            Person("Tina", 499, 22),
            Person("Raj", 634, 30),
            Person("Vikram", 721, 33),
            Person("Sneha", 568, 26),
            Person("Suman", 804, 24),
            Person("Yash", 912, 28),
            Person("Kavita", 753, 29),
            Person("Deepak", 622, 31),
            Person("Anita", 739, 25),
            Person("Pooja", 548, 27),
            Person("Karan", 823, 30),
            Person("Arjun", 671, 26),
            Person("Meena", 734, 24),
            Person("Farhan", 564, 28),
            Person("Aisha", 781, 29),
            Person("Isha", 459, 23),
            Person("Mira", 687, 25),
            Person("Sanjay", 598, 27),
            Person("Rakesh", 821, 30),
            Person("Suresh", 742, 32)
        )

        val personStrings = data2.map { person ->
            "${person.name}\nID: ${person.id}, Age: ${person.age}"
        }.toTypedArray()

        val customAdapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        val customAdapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, personStrings)
        b.lvMain.adapter = customAdapter2
        b.lvMain.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = personStrings[position]
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
        }
    }
}