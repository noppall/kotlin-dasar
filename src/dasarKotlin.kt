//variable const = variable mutable global diletakkan diluar function
//  const val KOTA:String = "malang";

//function
fun helloDunia(firstName:String, lastName:String? = null){
    println("halo semua planet")
}

//single expression function
fun pangkat(a: Int): Int = a * a; //jika mengembalikan nilai
fun nama(name: String): Unit = println("hello $name");

//extention function digunakan untuk membuat functionn baru pada tipe data
fun String.panggil(): String{
    return "Hello $this"
}

//varargs untuk menjadikan argumen array, argumen varargs harus berada paling kanan
fun hitungTotal(vararg values: Int): Int {
    var total = 0;

    for(value in values){
        total += value;
    }
    return total;
}

//infix notation function
infix fun String.to(tipe: String): String{
    when(tipe){
        "UP" -> return toUpperCase();
        "up" -> return toUpperCase();
        "Up" -> return toUpperCase();
        "uP" -> return toUpperCase();
        else -> {
            return toLowerCase();
        }
    }
}

//recursive function
fun factorialRecursive(angka: Int):Int {
    return when(angka) {
        1 -> 1
        else ->  angka * factorialRecursive(angka - 1);
    }
}

//tail recursive agar tidak terjadi stack overflow
tailrec fun hitungMundur(display: Int) {
    println("rekursif ke - $display");
    if(display>0){
        hitungMundur(display -1);
    }
}
//tail recursive faktorial
tailrec fun paktorial(nums: Int, total: Int): Int{
    return when(nums){
        1 -> total;
        else -> paktorial(nums - 1,nums * total)
    }
}

fun main(){
    //local function
    fun localScope(){
        println("tes local function");
    }
    localScope();

    
    


    //lambda function
    val contohLambda: (String, String) -> String = { firstName: String, lastName: String ->
        val hasil = "$firstName $lastName"
        hasil
    }
    val hasilLambda = contohLambda("nouval", "Farras")

    val lambdaJuga = {namamu: String, namaku: String ->
        val kita = "$namaku cinta $namamu"
        kita
    }
    
    //it pada lambda berfungsi sebagai parameter yang pertama tapi bisa jalan kalau parameternya 1, berfungsi agar tidak menulis ulang parameter
    val lambdaName: (String) -> String = {
        it.toUpperCase()
    }

    //method reference function, lambda yang mengambil function yang sudah ada
    val kaliKuadrat : (Int) -> Int = ::pangkat
    val kuadrat = kaliKuadrat(10)
    println(kuadrat)
    
    

    //higher order function, function yang menginputkan lambda
    fun hello(value:String, transformer:(String) -> String):String{
        return "hello ${transformer(value)}"
    }

    val perbesar = {kalimat: String -> kalimat.toUpperCase()}

    println(hello("Nopal", perbesar))
    println(hello("Minke", {kalimat: String -> kalimat.toLowerCase()}))



    //anonymous function



    //pemanggilan recursive
    println(factorialRecursive(10))

    //pemanggilan varargs
//    val jumlah = hitungTotal(10, 20, 30, 50, 70);
//    println(jumlah)

    //pemanggilan extention function
//    val nama: String = "nopal";
//    val sapa: String = nama.panggil(); //jadi function ini ditambahkan kepada tipe data
//    println(sapa)

    //pemanggilan infix function
//    val tanaman = "annggrek"
//    println(tanaman to "up");





    //nullable ditandai dengan tanda tanya pada akhiran tipe data
//    val enol:String? = null
//
//    //variable
//    //val mutable, var tidak
//    val nama:String = "nopal";
//    val umur:Int = 17;
//    println("$nama $umur $KOTA");

    //array
//    val tanahKelahiran: Array<String> = arrayOf("aceh","malang","yogya","makassar");
//    val nomorPunggung: Array<Byte> = arrayOf(30,20,50,10,12);
//    val menitBermain: Array<Float> = arrayOf(80.25f,78.38f,25.56f);
//
//    //get untuk mengmbil, sedangkan set untuk mengubah
//    val waktuTerlama: Float = menitBermain.get(1);
//    val gantiTempat = tanahKelahiran.set(3, "bandung");
//    nomorPunggung.set(2, 11);

    //range
//    val range = 1..100;
//    println(range.count());
//    println(range.contains(50));
//    println(range.contains(200));
//    println(range.first);
//    println(range.last);
//    println(range.step);
//    val range2 = 200 downTo 50 step 5;
//    println(range2.count());
//    println(range2.contains(50));
//    println(range2.contains(200));
//    println(range2.first);
//    println(range2.last);
//    println(range2.step);

    //if, else, else if
//    if (20 > 10) {
//        print("benar");
//    }else if(20 == 10){
//        print("sama")
//    }else{
//        print("salah")
//    }





    //when expression pengganti switch
//    when(20){
//        20 -> print("beanar 20");
//        10 -> print("salah bukan 10");
//        30, 40, 50 -> print("itu masih salah");
//        else -> {
//            print("coba lagi")
//        }
//    }
//    val hewan = "gajah"
//    val menyusui:Array<String> = arrayOf("gajah", "singa", "kera")
//    when(hewan){
//        in menyusui -> println("benar")
//        !in menyusui -> println("salah")
//    }
//    when(nama){
//        is String -> println("benar ini string")
//        !is String -> println("salah bukan string")
//    }





    //for loop
//    val hewan = arrayOf("elang", "gagak", "penguin", "gajah");
//    for(x in hewan){
//        println(x);
//    }
//    for(value in 10..200 step 2){
//        print(value);
//    }

    //while
//    var i = 0
//    while (i < 1000){
//        println(i)
//        i++
//        if (i == 1000){
//            break
//        }
//    }


}