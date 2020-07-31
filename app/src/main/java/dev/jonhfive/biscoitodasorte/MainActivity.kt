package dev.jonhfive.biscoitodasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frasesMotivacionais = arrayListOf(
                "Agora é a hora de começar a surpreender aqueles que duvidaram de você!",
                "Você nunca será velho demais para sonhar um novo sonho.",
                "Quando pensar em desistir, lembre-se porque começou.",
                "Se não puder fazer tudo, faça tudo que puder.",
                "Comece onde você está. Use o que você tem. Faça o que puder.",
                "Por mais difícil que algo possa parecer, jamais desista antes de tentar!",
                "Acreditar é a força que nos permite subir os maiores degraus da vida.",
                "No fim tudo dá certo, e se não deu certo é porque ainda não chegou ao fim."
        )

        val frasesBomDia = arrayListOf(
                "Tenha um bom dia! Que ele seja incrível e que você possa atingir todos os seus objetivos.",
                "O sol nasceu hoje trazendo muita energia e amor. Bom dia!",
                "Estou mandando muita energia positiva para que seu dia seja extraordinário! Bom dia!",
                "Bom dia a todos! Um novo dia é uma nova oportunidade de realizarmos nossos sonhos!",
                "Bom dia para você! Que a alegria esteja em cada segundo dessa manhã maravilhosa.",
                "Desejo a você um bom dia iluminado e repleto de intensidade!",
                "Bom dia! Hoje é o dia perfeito para conquistar o mundo!"
        )

        val frasesWhat = arrayListOf(
                "Nunca julgue um rinoceronte pelo preço do feijão.",
                "A cada passo, menos sapato.",
                "Sanduíche de batata recheado com pão pode ser prejudicial para batatas.",
                "O décimo quinto jacaré de um arco-íris é sempre o mais subestimado.",
                "Renas não gostam de lagosta.",
                "DELETE SEM WHERE!!!",
                "Um dólar na mão vale mais do que um pernilongo voando.",
                "Não beba gasolina vencida. Não beba gasolina antes do vencimento.",
                "Em terra de azeitona, quem tem CNH é motorista."
        )

        // Lista de opções do spinner
        val categorias = arrayListOf("Motivacional", "Bom Dia", "???")

        // Criar o adaptador
        val categoriasAdapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,
            categorias
        )

        // Plugar o adaptador
        spnMainCategoria.adapter = categoriasAdapter

        var cliquesUnknown = 0
        btnMainSort.setOnClickListener {
            val selecao = spnMainCategoria.selectedItem.toString()

            if (selecao == "Motivacional"){
                textView.text = frasesMotivacionais.random()
            } else if (selecao == "Bom Dia"){
                textView.text = frasesBomDia.random()
            } else if (selecao == "???"){
                // Criar caixa de diálogo
                val alert = AlertDialog.Builder(this@MainActivity)
                // Definir o título
                alert.setTitle("IhRapaz...")
                // Definir mensagem
                val mensagens = arrayListOf(
                    "Deseja continuar?",
                    "Tem certeza?",
                    "Quer mesmo isso?",
                    "Essa categoria não deveria existir...",
                    "Quanto é 2 + 2?"
                )
                alert.setMessage(mensagens.random())
                // Definir o botão Positivo
                alert.setPositiveButton("Sim") { dialog, wich ->
                    textView.text = frasesWhat.random()
                    cliquesUnknown += 1
                    if (cliquesUnknown == 5){
                        val mIntent = Intent(this@MainActivity, WebActivity::class.java)
                        startActivity(mIntent)
                    }
                }
                // Definir o botão Neutro
                alert.setNeutralButton("Não") {dialog, wich ->
                    Toast.makeText(this@MainActivity, "Sábia decisão.", Toast.LENGTH_SHORT).show()
                }
                // Exibir a caixa de diálogo
                if (cliquesUnknown < 5){
                    alert.show()
                } else {
                    textView.text = frasesWhat.random()
                }

            }
        }
    }
}