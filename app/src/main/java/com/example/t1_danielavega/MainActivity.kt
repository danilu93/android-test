package com.example.t1_danielavega

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Actividad principal de la aplicación
class MainActivity : AppCompatActivity() {

    // Metodo que se llama al crear la actividad
    // Aquí se inicializan los elementos de la interfaz y se configuran los eventos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al metodo onCreate de la clase padre AppCompatActivity
        setContentView(R.layout.activity_main) // Establece el diseño de la actividad a partir del archivo XML activity_main.xml

        // Referencias a los elementos de la interfaz
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        // Configuración del evento click para el botón de calcular
        btnCalcular.setOnClickListener {
            val numero1 = editTextNumber.text.toString().trim() // Obtiene el texto del primer EditText, lo convierte a String y elimina espacios en blanco
            val numero2 = editTextNumber2.text.toString().trim()

            // Validación para asegurarse de que ambos campos no estén vacíos
            if (numero1.isEmpty() || numero2.isEmpty()) {
                textViewResultado.text = "Por favor, ingrese ambos números" // Muestra un mensaje de error si alguno de los campos está vacío

                return@setOnClickListener // Sale del bloque de código del evento click si la validación falla
            }
            try {
                numero1.toDouble() // Intenta convertir el primer número a Double para verificar que sea un número válido
                numero2.toDouble() // Intenta convertir el segundo número a Double para verificar que sea un número válido
            } catch (e: NumberFormatException) {
                textViewResultado.text = "Por favor, ingrese números válidos" // Muestra un mensaje de error si la conversión a Double falla

                return@setOnClickListener // Sale del bloque de código del evento click si la validación falla
            }

            if (!numero1.matches(Regex("-?\\d+(\\.\\d+)?")) || !numero2.matches(Regex("-?\\d+(\\.\\d+)?"))) {
                textViewResultado.text = "Por favor, ingrese números válidos" // Muestra un mensaje de error si alguno de los campos no contiene un número válido

                return@setOnClickListener // Sale del bloque de código del evento click si la validación falla
            }
            try {
                numero1.toDouble() // Intenta convertir el primer número a Double para verificar que sea un número válido
                numero2.toDouble() // Intenta convertir el segundo número a Double para verificar que sea un número válido
            } catch (e: NumberFormatException) {
                textViewResultado.text = "Por favor, ingrese números válidos" // Muestra un mensaje de error si la conversión a Double falla

                return@setOnClickListener // Sale del bloque de código del evento click si la validación falla
            }

            // Realiza la suma de los dos números ingresados, convirtiéndolos a Double para permitir decimales
            val suma = numero1.toDouble() + numero2.toDouble() // Realiza la suma de los dos números ingresados

            // Determina cuál de los dos números es menor, mayor o igual utilizando expresiones condicionales
            val numeros = when {
                numero1.toDouble() < numero2.toDouble() -> "El número MENOR es: $numero1\n El número MAYOR es: $numero2" // Si numero1 es menor que numero2, se muestra que numero1 es el menor y numero2 es el mayor
                numero2.toDouble() < numero1.toDouble() -> "El número MENOR es: $numero2\n El número MAYOR es: $numero1" // Si numero2 es menor que numero1, se muestra que numero2 es el menor y numero1 es el mayor
                else -> "Ambos números son iguales" // Si ambos números son iguales, se muestra un mensaje indicando que son iguales

            }

            // Calcula la diferencia entre los dos números, asegurándose de que el resultado sea positivo utilizando una expresión condicional
            val diferencia = if (numero1.toDouble() > numero2.toDouble()) numero1.toDouble() - numero2.toDouble() else numero2.toDouble() - numero1.toDouble() // Calcula la diferencia entre los dos números, asegurándose de que el resultado sea positivo

            // Crea un mensaje con el resultado de la suma, el número menor, el número mayor y la diferencia entre los dos números
            val resultado = " El total de la suma es: $suma\n $numeros\n La diferencia es de: $diferencia" // Crea un mensaje con el resultado de la suma, el número menor, el número mayor y la diferencia entre los dos números
            textViewResultado.text = resultado // Muestra el resultado en el TextView
        }


    }
}

