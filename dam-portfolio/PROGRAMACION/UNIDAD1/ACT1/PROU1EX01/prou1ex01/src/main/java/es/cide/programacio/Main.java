//nom: Álvaro Muntaner Lucas
//data: 25/09/2025
package es.cide.programacio;

public class Main {
    public static void main(String[] args) {
        //INDICA ELS IDENTIFICADORS CORRECTES
        int registro1;//Correcte.
        //int 1registro;//Incorrecte perque comença un nombre.
        int archivo_3;//Correcte.
        //int while;//Incorrecte perque "while" es una paraula reservada.
        int $impuesto;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un caracter especial, en aquest cas el "$".
        int año;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un caracter especial, en aquest cas el "ñ".
        //int primer apellido;//Incorrecte, dona syntax error en "apellido" degut a que hi ha un espai.
        int primer_apellido;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un caracter especial, en aquest cas el "_".
        //int primer-apellido;//Incorrecte per contenir un caracter especial, en aquest cas el "-".
        int primerApellido;//Correcte
        //int Tom’s;//Incorrecte per contenir un caracter especial, en aquest cas el "?".
        int C3PO;//Correcte
        //int 123#;//Incorrecte per començar per un nombre i contenir el caracter especial "#".
        int PesoMáximo;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un accent.
        //int %descuento;//Incorrecte per començar per un caracter especial "%".
        int Weight;//Correcte
        int $$precioMínimo;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un caracter especial, en aquest cas el "$", i a part tenir accent.
        int _$Único;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir els caracters especials "_" i "$" i a part tenir accent.
        int tamaño_màximo;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir els caracters especials "ñ" i "_" i a part tenir accent.
        //int peso.maximo;//Incorrecte perque el "." a JAVA es un caracter reservat que substitueix la ","
        int Precio___;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un caracter especial, en aquest cas el "___".
        //int matrícula?;//Incorrecte per contenir un caracter especial, en aquest cas el "?".
        int cuántoVale;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un accent.
        int high;//Correcte
        int barça;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un caracter especial, en aquest cas el "ç".
        int piragüista;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un caracter especial, en aquest cas el "ü".
        int B_011;//NO DONA SYNTAX ERROR PERO: Incorrecte per contenir un caracter especial, en aquest cas el "_".
        int X012AB;//Correcte
        //int 70libro;//incorrecte perque comença un nombre.
        //int nombre&apellido;//Incorrecte per contenir un caracter especial, en aquest cas el "&".
        //int 0X1A;//incorrecte perque comença un nombre.
        //int else;//Incorrecte perque "else" es una paraula reservada.
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //INDICA ELS LITERALS CORRECTE
        double aaa = 0.5; //He posat l'etiqueta "double" perque es tracta d'un nombre real.
        System.out.println (aaa);
        double bbb = .5;//He posat l'etiqueta "double" perque es tracta d'un nombre enter que es troba en el rang de (-128/+127).
        System.out.println (bbb);
        double ccc = 9.3e12;//He posat l'etiqueta "double" perque es tracta d'un nombre real que te una presicio aproximada de 16 digits.
        System.out.println (ccc);
        double d = 9.3e-12;//He posat l'etiqueta "double" perque es tracta d'un nombre real que te una presicio aproximada de 16 digits.
        System.out.println (d);
        int e = 12345678;//He posat l'etiqueta "int" perque es tracta d'un nombre enter que es troba en el rang (-2.147.483.648/2.147.483.647).
        System.out.println (e);
        //int f = 12345678_L;//Es incorrecte degut a que no pot haver un caracter especial com "_" ni una lletra "l".
        //double g = 0.8E+0.8;//Es incorrecte perque la lletra "E" no pot anar seguida d'una suma, ha de anar seguida d'un terme.
       //double h = 0.8E 8;//Es incorrecte perque no hi pot haver un espai entre "E" i el seguent terme.
        short i = 05_15;//He posat l'etiqueta "short" perque es tracta d'un nombre enter que es troba en el rang de (-32768/+32767).
        System.out.println (i);
        //short j = 018CDF;//Incorrecte perque al ser octal no pot contenir un 8.
        int k = 0XBC5DA;//He posat l'etiqueta "int" perque es tracta d'un nombre enter que es troba en el rang (-2.147.483.648/2.147.483.647).
        System.out.println (k);
        int l = 0x87e3a;//He posat l'etiqueta "int" perque es tracta d'un nombre enter que es troba en el rang (-2.147.483.648/2.147.483.647).
        System.out.println (l);
        long m = 234567L;//He posat l'etiqueta "long" perque es tracta d'un nombre enter que es troba en el rang de ( -9.223.372.036.854.775.808/9.223.372.036.854.775.807) i te el caracter "l".
        System.out.println (m);
        //int n = 0_B11;//Incorrecte perque no pot haver el caracter especial "_" entre un nombre i una lletra.
        short o = 010101;//He posat l'etiqueta "short" perque es tracta d'un nombre enter que es troba en el rang de (-32768/+32767).
        System.out.println (o);
        short ppp = 0_557;//He posat l'etiqueta "short" perque es tracta d'un nombre enter que es troba en el rang de (-32768/+32767).
        System.out.println (ppp);
        //int qqq = .00.8E2;//Incorrecte perque no pot haver dos "." a un mateix valor.
        float r = .3e3f;//He posat l'etiqueta "float" perque es tracta d'un nombre real amb una precisio aproximada de 7 digits i te l'etiqueta "F".
        System.out.println (r);
        byte s = 0b111;//He posat l'etiqueta "byte" perque es tracta d'un nombre en binari que es troba en el rang de (-128/+127). 
        System.out.println (s);
        long t = 12_234L;//He posat l'etiqueta "long" perque es tracta d'un nombre enter que es troba en el rang de ( -9.223.372.036.854.775.808/9.223.372.036.854.775.807) i te el caracter "l".
        System.out.println(t);
        int u = 0Xabcd;//He posat l'etiqueta "int" perque es tracta d'un nombre enter que es troba en el rang (-2.147.483.648/2.147.483.647).  
        System.out.println(u);
        long w = 0xabcEL;//He posat l'etiqueta "long" perque es tracta d'un nombre enter que es troba en el rang de ( -9.223.372.036.854.775.808/9.223.372.036.854.775.807) i te el caracter "l".
        System.out.println(w);
        //byte xxx  = _234;//Incorrecte perque no es por començar el valor d'ina variable amb el caracter especial "_".
        //int yyy = 1010B;//Incorrecte perque la lletra "B" hauria d'anar en la segona posició per que fos binari.
        //int zzz = 0x1010B//Incorrecte perque els nombres hexadecimals no poden acabar amb el terme "B".
        double aa = 1_234.2E-2;//He posat l'etiqueta "double" perque es tracta d'un nombre real que te una presicio aproximada de 16 digits.
        System.out.println(aa);
        //double ab = 1234.2EF;//Incorrecte perque en aquest cas la lletra "E" ens esta indicant un double, mentre que la lletra "f" un float, per tant posat les dues lletres seguides una de l'altra no es un format apte.
        float ac = 1234.2E3F;//He posat l'etiqueta "float" perque es tracta d'un nombre real amb una precisio aproximada de 7 digits i te l'etiqueta "F".
        System.out.println(ac);
        //double ad = 1_1.2e_2;//Incorrecte perque conte el caracter especial "_".
        //int ae = 0bABCDL;//Incorrecte perque les lletres "ABCDL" no es comprenen dintre els nombres binaris.
        byte af = 0X1A;//He posat l'etiqueta "byte" perque es tracta d'un nombre hexadecimal que es troba en el rang de (-128/+127).
        System.out.println(af);
        //Long ag = 0X12AL//Incorrecte perque la lletra "L" al final d'un nombre indica que es una variable long mentre que la lletra "A" indica hexadecimals.
        //long ah = abcd;//Incorrecte perque un literal no pot començar amb lletres sense els prefixes de octal, hexadecimal o binari
        byte ai = 0125;//He posat l'etiqueta "byte" perque es tracta d'un nombre enter que es troba en el rang de (-128/+127).
        System.out.println(ai);
        double aj = .01011;//He posat l'etiqueta "double" perque es tracta d'un nombre real que te una presicio aproximada de 16 digits.
        System.out.println(aj);
        double ak = 3e12;//He posat l'etiqueta "double" perque es tracta d'un nombre enter que te una presicio aproximada de 16 digits.
        System.out.println(ak);
        //double al = 3_e12//Incorrecte perque el caracter especial "_" no pot estar al principi d'un nombre.
        double am = -3E-1_2;//He posat l'etiqueta "double" perque es tracta d'un nombre enter que te una presicio aproximada de 16 digits.
        System.out.println(am);
        //float an = 0.8E;//Incorrecte perque falta l'exponent de "E" que seria la potencia a la que s'eleva el 10 per multiplicar-ho.
        //byte ao = 0B1212;//Incorrecte perque en una seqüencia binaria no hi poden apareixer mes digits que no siguin el "1" o "0".
        byte ap = 1_2_3;//He posat l'etiqueta "byte" perque es tracta d'un nombre enter que es troba en el rang de (-128/+127).
        System.out.println(ap);
        int aq = 0xedad;//He posat l'etiqueta "int" perque es tracta d'un nombre hexadecimal que es troba en el rang (-2.147.483.648/2.147.483.647).
        System.out.println(aq);
        short ar = 0XBE2;//He posat l'etiqueta "short" perque es tracta d'un nombre hexadecimal que es troba en el rang de (-32768/+32767).
        System.out.println(ar);
        double as = 101e2;//He posat l'etiqueta "double" perque es tracta d'un nombre enter que te una presicio aproximada de 16 digits.
        System.out.println(as);
        //byte at = B1101;//Incorrecte perque els valors binaris han de començar sempre pel prefixe "0b".
        //float au = 1.34.5//Incorrecte perque no hi pot haver un segon "." en un nombre decimal.
        float av = 12.3E4F;//He posat l'etiqueta "float" perque es tracta d'un nombre real amb una precisio aproximada de 7 digits i te l'etiqueta "F".
        System.out.println(av);
        //int aw = 0X12AG;//Incorrecte perque els nombres hexadecimals unicament poden contenir digits del (1,9) i les lletres desde "A" fins "f".
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Exercicis de literals del tipus “char”  
        char a1 = 'a';//Correcte.
        System.out.println(a1);
        char b1 = '$';//Correcte.
        System.out.println(b1);
        char c1 = '\n';//Correcte.
        System.out.println(c1);
        //char d1 = '/n';//Incorrecte perque el simbol "/" es un caracter reservat.
        char e1 = '\\';//Correcte.
        System.out.println(e1);
        //char f1 = '\ñ;//Incorrecte perque "'\ñ" no es una seqüencia valida ("\n, \t, \\, \', \").
        //char g1 = "T";//Incorrecte perque les cometes dobles "" defineixen literals de tipus (String), en canvi pels literals de tipus (char) s'utilitzen les cometes simples' '.
        char h1 = 'ñ';//Correcte.
        System.out.println(h1);
        //char i1 = 'xyz';//Incorrecte perque els literals de tipus (char) unicament poden contenir un unic caracter o una seqüencia valida.
        char j1 = '\u0066';//Correcte, la seqüencia ('\u0066') es reconeguda com el caracter "f".
        System.out.println(j1);
        //char k1 = "XYZ";//Incorrecte perque les cometes dobles "" defineixen literals de tipus (String), en canvi pels literals de tipus (char) s'utilitzen les cometes simples' ', a part els literals de tipus (char) unicament poden contenir un unic caracter o una seqüencia valida.
        char l1 = '4';//Correcte.
        System.out.println(l1);
        char m1 = '\t';
        System.out.println(m1);
        char n1 = '\b';
        System.out.println(n1);
        //char o1 = k;//Incorrecte perque els literals de tipus (char) han d'anar entre cometes simples ' '.
        //char p1 = +;//Incorrecte perque els literals de tipus (char) han d'anar entre cometes simples ' '.
        char q1 = '+';//Correcte.
        System.out.println(q1);
        char r1 = '?';//Correcte.
        System.out.println(r1);
        char s1 = 'â';//Correcte.
        System.out.println(s1);
        char t1 = ':';
        System.out.println(t1);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Exercicis sobre strings
        //String a2 = '8:15 P.M.';// //Incorrecte perque les cometes simples ' ' defineixen literals de tipus (char), en canvi pels literals de tipus (String) s'utilitzen les cometes dobles "".
        String b2 = "Rojo, Blanco y Azul";//Correcte.
        System.out.println(b2);
        //String c2 = "Nombre:;//Incorrecte perque els literals de tipus (String) han d'anar oberts i tancats per una cometa doble "".
        //Sring d2 = "Capítulo \’3\’";//Incorrecte perque (\’) no es una seqüencia valida.
        String e2 = "1.3e-1-2";//Correcte.
        System.out.println(e2);
        String f2 = "";//Correcte.
        System.out.println(f2);
        String g2 = " ";//Correcte.
        System.out.println(g2);
        String h2 = "A";//Correcte.
        System.out.println(h2);
        //String i2 = "FP';//Incorrecte perque els literals de tipus (String) han d'anar oberts i tancats per una cometa doble "".
        String j2 = " programación ";//Correcte.
        System.out.println(j2);
        //String k2 = "programación "Java"";//Incorrecte perque els literals de tipus (String) no admeteixen cometes dobles internes unicament obertes sense tencar-les.
        //String l2 = programación;//Incorrecte perque els literals de tipus (String) han d'anar oberts i tancats per una cometa doble "".
        //string m2 = 'W';//Incorrecte perque les cometes simples ' ' defineixen literals de tipus (char), en canvi pels literals de tipus (String) s'utilitzen les cometes dobles "".
        String n2 = "\n";//Correcte.
        System.out.println(n2);
        String o2 = "4 + 5 * 2";//Correcte.
        System.out.println(o2);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Declara les següents variables
        // a) Variables enteras
        int p = 1, q = 2;
        System.out.println(p);
        System.out.println(q);
        // b) Variables float
        float x = 1.1f, y = 2.2f, z = 3.3f;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        // c) Variables carácter
        char a = 'A', b = 'B', c = 'C';
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        // d) Variables double
        double raiz1 = 1.0, raiz2 = 2.0;
        System.out.println(raiz1);
        System.out.println(raiz2);
        // e) Variable entera larga
        long contador = 100000L;
        System.out.println(contador);
        // f) Variable entera corta
        short indicador = 1;
        System.out.println(indicador);
        // g) Variable entera
        int indice = 1;
        System.out.println(indice);
        // h) Variables double
        double precio = 0.99, precioFinal = 1.99;
        System.out.println(precio);
        System.out.println(precioFinal);
        // i) Variables carácter
        char car1 = 'X', car2 = 'Y';
        System.out.println(car1);
        System.out.println(car2);
        // j) Variable tipo byte
        byte valor = 123;
        System.out.println(valor);
        // k) Variables lógicas
        boolean primero = true, ultimo = false;
        System.out.println(primero);
        System.out.println(ultimo);
        // l) Variable tipo String
        String nombre = "Álvaro Muntaner Lucas";
        System.out.println(nombre);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Declara aquestes variables
        byte edad = 18;//He emprat el tipus "byte" perque l'edat es un nombre enter que es troba en el rang de (-128/+127).
        System.out.println(edad);
        int codigoPostal = 77711;//He emprat el tipus "int" perque els codis postals son nombres enters que es troben en el rang (-2.147.483.648/2.147.483.647).
        System.out.println(codigoPostal);
        float altura = 1.65f;//He emprat el tipus "float" perque l'altura es nombre real (decimal) amb una precisio aproximada de 7 digits i per aixo te l'etiqueta "F".
        System.out.println(altura);
        char generoHombre = 'H';//He emprat el tipus "char" per guardar un unic caracter.
        System.out.println(generoHombre);
        char generoMujer = 'M';//He emprat el tipus "char" per guardar un unic caracter.
        System.out.println(generoMujer);
        String nombre_ = "Álvaro";
        System.out.println(nombre_);
        byte numeroDeHijos = 2;//He emprat el tipus "byte" perque el nombre de fills que pot tenir una dona es un nombre enter que es troba en el rang de (-128/+127).
        System.out.println(numeroDeHijos);
        float iva = 21.0f;//He emprat el tipus "float" perque l'iva es un percentatge entre el 0 i el 100, per tant, es nombre real (decimal) amb una precisio aproximada de 7 digits i per aixo te l'etiqueta "F".
        System.out.println(iva);
        byte tallaCamisa = 36;//He emprat el tipus "byte" perque les talles que pot tenir una camisa son un nombre enter que es troba en el rang de (-128/+127).
        System.out.println(tallaCamisa);
        float peso = 70.5f;//He emprat el tipus "float" perque el pes es un nombre real (decimal) amb una precisio aproximada de 7 digits i per aixo te l'etiqueta "F".
        System.out.println(peso);
        float precio_ = 0.99f;//He emprat el tipus "float" perque el preu es un nombre real (decimal) amb una precisio aproximada de 7 digits i te l'etiqueta "F".
        System.out.println(precio_);
        boolean alumnoRepetidor = true;//He emprat el tipus "boolean" perque només pot tenir dos valors: true (SI) o false (NO).
        System.out.println(alumnoRepetidor);
        String mensaje = "Holaa";//He emprat el tipus "String" perque es tracta d'un literal de text, que pot contenir multiples caracters.
        System.out.println(mensaje);
        char letra = 'A';//He emprat el tipus "char" per guardar un unic caracter.
        System.out.println(letra);
        byte mayorEdad = 18;//He emprat el tipus "byte" perque l'edat es un nombre enter que es troba en el rang de (-128/+127).
        System.out.println(mayorEdad);
        byte minutos = 30;//He emprat el tipus "byte" perque els minuts son una xifra que va de 0 a 60 i es tracta d'un nombre enter que es troba en el rang de (-128/+127).
        System.out.println(minutos);
        byte dias = 30;//He emprat el tipus "byte" perque els dies son una xifra que va de 1 a 31 i es tracta d'un nombre enter que es troba en el rang de (-128/+127).
        System.out.println(dias);
        String matriculaCoche = "1234ABC";//He emprat el tipus "String" perque es tracta d'un literal de text que pot contenir numeros i lletres.
        System.out.println(matriculaCoche);
        int contador_ = 100;//He emprat el tipus "int" perque es tracta d'un nombre enter que es troba en el rang de (-2.147.483.648/2.147.483.647).
        System.out.println(contador_);
        boolean mayorDeEdad = true;//He emprat el tipus "boolean" perque nomes pot tenir dos valors: true (SI) si es major de edat o false (NO) si no ho es.
        System.out.println(mayorDeEdad);
        String tallaCamiseta = "M";//He emprat el tipus "String" perque es tracta d'un literal de text que indica la talla de la camiseta.
        System.out.println(tallaCamiseta);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Convertir les expressions algebràiques a algotímiques
        //a)
        float a_a = 1, a_b = 2, a_c = 3;
        float a_resultat = a_b/2-4*a_a*a_c;//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(a_resultat);
        //b)
        int b_x = 1, b_y = 2;
        int b_resultat = (3*b_x*b_y)-(5*b_x)+(12*b_x)-17;//He emprat el tipus "int" perque es tracta d'una operacio de nombres enters.
        System.out.println(b_resultat);
        //c)
        float c_b = 1, c_d = 2, c_c = 3;
        float c_resultat = (c_b+c_d)/(c_c+4);//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(c_resultat);
        //d)
        float d_x = 1, d_y = 2;
        float d_resultat = (d_x*d_y/d_y)+2;//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(d_resultat);
        //e)
        float e_x = 1, e_y = 2, e_z = 3;
        float e_resultat = (1/e_y)+(3*e_x/e_z)+1;//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(e_resultat);
        //f)
        float f_x = 1, f_y = 2;
        float f_resultat = (1/(f_y+3))+(f_x/f_y)+0;//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(f_resultat);
        //g)
        float g_x = 1, g_y = 2;
        float g_resultat = 1/g_y + (3+g_x)/(g_y+1);//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(g_resultat);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Convertir les expressions algebràiques a algorítmiques (segon exercici)
        //a)
        float a2_a = 1, a2_b = 2, a2_c = 3, a2_d = 4;
        float a2_resultat = a2_a/a2_b + a2_c/a2_d;//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(a2_resultat);
        //b)
        float b2_a = 1, b2_b = 2, b2_c = 3, b2_d = 4;
        float b2_resultat = 1/(b2_a-b2_b) - (b2_c*b2_a*b2_d/4);//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(b2_resultat);
        //c)
        float c2_resultat = (1/2)+7;//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(c2_resultat);
        //d
        float d2_resultat = 7+(1/2);//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(d2_resultat);
        //e)
        float e2_a = 1, e2_b = 2, e2_c = 3, e2_d = 4, e2_e = 5, e2_f = 6, e2_g = 7, e2_h = 7, e2_j = 8;
        double e2_resultat = (Math.pow(e2_a,2)/(e2_b-e2_c) + (e2_d-e2_e)/(e2_f-(e2_g*e2_h/e2_j)));//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(e2_resultat);
        //f)
        float f2_m = 1, f2_n = 2, f2_p = 3;
        float f2_resultat = (f2_m/f2_n)+f2_p;//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(f2_resultat);
        //g)
        float g2_m = 1, g2_n = 2, g2_p = 3, g2_q = 4;
        float g2_resultat = g2_m+(g2_n/(g2_p-g2_q));//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(g2_resultat);
        //h)
        float h2_a = 2, h2_b = 2, h2_c = 3, h2_d = 4;
        float h2_resultat = (float)(Math.pow(h2_a,2)/Math.pow(h2_b,2) + Math.pow(h2_c,2)/Math.pow(h2_d,2));//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(h2_resultat);
        //i)
        float i2_m = 1, i2_n = 2, i2_p = 3, i2_q = 4, i2_r = 5, i2_s = 6;
        float i2_resultat = (i2_m+(i2_n/i2_p))/(i2_q-(i2_r/i2_s));//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(i2_resultat);
        //j)
        float j2_a = 1, j2_b = 2, j2_c = 3, j2_d = 4, j2_e = 5, j2_f = 6, j2_g = 7, j2_h = 9;
        float j2_resultat = (3*j2_a+j2_b)/(j2_c-((j2_d+5*j2_e)/(j2_f+(j2_g/(2*j2_h)))));//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(j2_resultat);
        //k)
        float k2_a = 1, k2_b = 2, k2_x = 3;
        float k2_resultat = (float)((Math.pow(k2_a,2)+2*k2_a*k2_b+Math.pow(k2_b,2))/((1/Math.pow(k2_x,2))+2));//He emprat el tipus "float" perque els valors poden ser decimals i la precisio es aproximada a 7 digits.
        System.out.println(k2_resultat);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Si a, b y c son variables senceres amb valors a=8, b=3, c=-5, determina el valor de les següents expressions aritmètiques:
        byte a3 = 8, b3 = 3, c3 = -5;//He utilitzat el "byte" perque totes les variables tenen valor de nombres enters en un rang de (-128/+127).
        //a) a + b + c
        System.out.println(a3+b3+c3);
        //b) 2 * b + 3 * (a – c)
        System.out.println(2*b3+3*(a3-c3));
        //c) a / b  
        System.out.println(a3/b3);
        //d)a % b//Apunt: El simbol % torna la resta d'una divisió entre dos nombres enters,
        System.out.println(a3%b3);
        //e)a / c
        System.out.println(a3/c3);
        //f)a % c
        System.out.println(a3%c3);
        //g)a * b / c
        System.out.println(a3*b3/c3);
        //h)a * (b / c)
        System.out.println(a3*(b3/c3));
        //i) (a * c) % b
        System.out.println((a3*c3)%b3);
        //j) a * (c % b)
        System.out.println(a3*(c3%b3));
        //k) (3 * a – 2 * b) % (2 * a – c)
        System.out.println((3*a3-2*b3)%(2*a3-c3));
        // l) 2 * ( a / 5 + (4 - b * 3)) % (a + c - 2)
        System.out.println(2*(a3/5+(4-b3*3))%(a3+c3-2));
        //m) (a - 3 * b) % (c + 2 * a) / (a - c)
        System.out.println((a3-3*b3)%(c3+2*a3)/(a3-c3));
        //n) a - b - c * 2
        System.out.println(a3-b3-c3*2);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Si x, y, z son variables de tipus double amb valors x= 88, y = 3.5, z = -5.2, determina el valor de les següents expressions aritmètiques. Obtén el resultat de cada expressió amb un màxim de quatre decimals.
        float x4 = 88f, y4 = 3.5f, z4 = -5.2f; //He emprat el tipus "float" perque es tracta de nombres reals amb decimals decimals i la precisio es aproximada a 7 digits.
        //a) x + y + z
        System.out.println(x4+y4+z4);
        //b) 2 * y + 3 * (x – z)
        System.out.println(2*y4+3*(x4-z4));
        //c) x / y
        System.out.println(x4/y4);
        //d) x % y
        System.out.println(x4%y4);
        //e) x / (y + z)
        System.out.println(x4/(y4+z4));
        //f) (x / y) + z
        System.out.println((x4/y4)+z4);
        //g) 2 * x / 3 * y
        System.out.println(2*x4/3*y4);
        //h) 2 * x / (3 * y)
        System.out.println(2*x4/(3*y4));
        //i) x * y % z
        System.out.println(x4*y4%z4);
        //j) x * (y % z)
        System.out.println(x4*(y4%z4));
        //k) 3 * x – z – 2 * x
        System.out.println(3*x4-z4-2*x4);
        //l) 2 * x / 5 % y
        System.out.println(2*x4/5%y4);
        //m) x - 100 % y % z
        System.out.println(x4-100%y4%z4);
        //n) x - y - z * 2
        System.out.println(x4-y4-z4*2);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //A partir de les següents declaracions de variables:
        byte b5 = 1;
        short s5 = 190;
        long ln5 = 199l;
        int i5 = 500, j5 = 900;
        float f5 = 5.5f;
        double d5 = 9.9d; 
        char c5 = 'c';
        //Determina quin és el tipus de data del resultat de les següents expressions aritmètiques:
        //a) i + c
        //System.out.println(i5+c5);//Incorrecte, encara que no dona error, no es posible sumar un caracter (char) amb un nombre enter (int).
        //b) f - c
        //System.out.println(f5-c5);//Incorrecte, encara que no dona error, no es posible restar un caracter (char) amb un nombre decimal (float).
        //c) d + f
        System.out.println(d5+f5);//Correcte, imprimeix com a resultat una data de tipus (double).
        //d) d + i
        System.out.println(d5+i5);//Correcte, imprimeix com a resultat una data de tipus (double).
        //e) i / f
        System.out.println(i5/f5);//Correcte, imprimeix com a resultat una data de tipus (float).
        //f) s + j
        System.out.println(s5+j5);//Correcte, imprimeix com a resultat una data de tipus (float).
        //g) d + j
        System.out.println(d5+j5);//Correcte, imprimeix com a resultat una data de tipus (double).
        //h) s * c
        //System.out.println(s5*c5);//Incorrecte, encara que no dona error, no es posible multiplicar un caracter (char) amb un nombre enter (short).
        //i) d + c
        //System.out.println(d5+c5);//Incorrecte, encara que no dona error, no es posible sumar un caracter (char) amb un nombre decimal (double).
        //j) b + c
        //System.out.println(b5+c5);//Incorrecte, encara que no dona error, no es posible sumar un caracter (char) amb un nombre enter (byte).
        //k) b / c + s
        //System.out.println(b5/c5+s5);////Incorrecte, encara que no dona error, no es posible operar un caracter (char) amb nombres.
        //l) c + c
        //System.out.println(c5+c5);//Incorrecte, encara que no dona error, no es possible sumar un caracter (char) amb un altre caracter (char).
        //m) i + ln + d
        System.out.println(i5+ln5+d5);//Correcte, imprimeix com a resultat una data de tipus (double).
        //n) ln + c
        //System.out.println(ln5+c5);//Incorrecte, encara que no dona error, no es possible sumar un caracter (char) amb un nombre long.
        //o) 5 / j
        System.out.println(5/j5);//Correcte, imprimeix com a resultat una data de tipus (int).
        //p) 5.2 / j
        System.out.println(5.2/j5);//Correcte, imprimeix com a resultat una data de tipus (double).
        //q) i * f * 2.5
        System.out.println(i5*f5*2.5);//Correcte, imprimeix com a resultat una data de tipus (double).
        //r) ln * f * 2.5F
        System.out.println(ln5*f5*2.5F);//Correcte, imprimeix com a resultat una data de tipus (float).
        //s) j - 4L
        System.out.println(j5-4L);//Correcte, imprimeix com a resultat una data de tipus (long).
        //t) j - 4L * 2.5F
        System.out.println(j5-4L*2.5F);//Correcte, imprimeix com a resultat una data de tipus (float).
        //u) b + 2.5 * i + 35F
        System.out.println(b5+2.5*i5+35F);//Correcte, imprimeix com a resultat una data de tipus (double).
        //v) 'a' + b
        //System.out.println('a'+b5);//Incorrecte, encara que no dona error, no es possible sumar un caracter (char) amb un nombre enter (byte).
        //w) c + 2
        //System.out.println(c5+2);//Incorrecte, encara que no dona error, no es possible sumar un caracter (char) amb un nombre enter (int).
        //x) c + 2
        //System.out.println(c5+2);//Incorrecte, encara que no dona error, no es possible sumar un caracter (char) amb un nombre enter (int).
        //y) c - ln / 2
        //System.out.println(c5-ln5/2);//Incorrecte, encara que no dona error, no es possible operar un caracter (char) amb un nombre (long).
        //z) 2 / i + 2.0 / j
        System.out.println(2/i5+2.0/j5);//Correcte, imprimeix com a resultat una data de tipus (double).
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Si X, Y y Z son variables de tipus boolean amb valors X = true, Y = false, Z = true, determina el valor de les següents expressions lògiques:
        boolean x6 = true, y6 = false, z6 = true;
        //a) (X && Y) || (X && Z)
        System.out.println((x6&&y6)||(x6&&z6));//En aquest cas, el resultat es vertader.
        //b) (X || !Y)&& (!X || Z)
        System.out.println((x6||!y6)&&(!x6||z6));//En aquest cas, el resultat es vertader.
        //c) X || Y && Z 
        System.out.println(x6||y6&&z6);//En aquest cas, el resultat es vertader.
        //d) !(X || Y) && Z
        System.out.println(!(x6||y6)&&z6);//En aquest, cas el resultat es fals.
        //e) X || Y || X && !Z && !Y
        System.out.println(x6||y6||x6&&!z6&&!y6);//En aquest cas el resultat es vertader.
        //f) !X || !Y || Z && X && !Y
        System.out.println(!x6||!y6||z6&&x6&&!y6);//En aquest cas, el resultat es vertader.
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Si W, X i Y son variables de tipus boolean amb valors W = false, X = true, Y = true, Z = false,  determina el valor de les següents expressions lògiques:
        boolean w7 = false, x7 = true, y7 = true, z7 = false;
        //a) W || Y && X && W || Z 
        System.out.println(w7||y7&&x7&&w7||z7);//En aquest, cas el resultat es fals.
        //b) X && !Y && !X || !W && Y
        System.out.println(x7&&!y7&&!x7||!w7&&y7);//En aquest cas, el resultat es vertader.
        //c) !(W || !Y) && X || Z 
        System.out.println(!(w7||!y7)&&x7||z7);//En aquest cas, el resultat es vertader.
        //d) X && Y && W || Z || X
        System.out.println(x7&&y7&&w7||z7||x7);//En aquest cas, el resultat es vertader.
        //e) Y || !(Y || Z && W)
        System.out.println(y7||!(y7||z7&&w7));//En aquest cas, el resultat es vertader.
        //f) !X && Y && (!Z || !X)
        System.out.println(!x7&&y7&&(!z7||!x7));//En aquest, cas el resultat es fals.
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //A partir de les sigüents declaracions de variables:
        int i8 = 8, j8 = 5;
        float x8 = 0.005F, y8 = -0.01F;
        char c8 = 'c', d8 = 'd';
        //Determina el valor de les següents expressions:
        //a) i <= j
        System.out.println(i8<=j8);//El resultat es fals.
        //b) c > d
        System.out.println(c8>d8);//El resultat es fals.
        //c) x >= 0
        System.out.println(x8>=0);//El resultat es vertader.
        //d) x < y--
        System.out.println(x8<y8--);//El resultat es fals.
        //e) j != 6
        System.out.println(j8!=6);//El resultat es vertader.
        //f) c == 99
        System.out.println(c8==99);//El resultat es vertader.
        //g) !(i <= j)
        System.out.println(!(i8<=j8));//El resultat es vertader.
        //h) !(c == 99)
        System.out.println(!(c8==99));//El resultat es fals.
        //i) !(x > 0)
        System.out.println(!(x8>0));//El resultat es fals.
        //j) –j == i - 13
        System.out.println(-j8==i8-13);//El resultat es vertader.
        //k) ++x > 0
        System.out.println(++x8>0);//El resultat es vertader.
        //l) y-- < 1
        System.out.println(y8--<1);//El resultat es vertader.
        //m) c > d || c > 0
        System.out.println(c8>d8||c8>0);//El resultat es vertader.
        //n) 5 * (i + j) > 'c'
        System.out.println(5*(i8+j8)>'c');//El resultat es fals.
        //o) 2 * x + y == 0
        System.out.println(2*x8+y8==0);//El resultat es fals.
        //p) 2 * x + (y == 0)
        //System.out.println(2*x8+(y8==0));//Incorrecte, l'error que surt al terminal del java diu que es pel signe "+", jo suposo que l'error te a veure amb que els operandos no son del mmateix tipus.
        //p) x + y  >= 0
        System.out.println(x8+y8>=0);//El resultat es fals.
        //r) x < ++y
        System.out.println(x8<++y8);//El resultat es fals.
        //s) – (i + j) != -i + j
        System.out.println(-(i8+j8)!=-i+j8);//El resultat es vertader.
        //t) i <= j && i >= c
        System.out.println(i8<=j8&&i8>=c);//El resultat es fals.
        //u) i > 0 && j < 5
        System.out.println(i8>0&&j8<5);//El resultat es fals.
        //v) i > 0 || j < 5
        System.out.println(i8>0||j8<5);//El resultat es vertader.
        //w) x > y && i > 0 || j < 5
        System.out.println(x8>y8&&i8>0||j8<5);//El resultat es vertader.
        //x) (3 * i – 2 * j) % (2 * d – c) > 3 * d
        System.out.println((3*i8-2*j8)%(2*d8-c8)>3*d8);//El resultat es fals.
        //y) 2 * ((i / 5) + (4 * (j – 3)) % (i + j – 2)) >= 10
        System.out.println(2*((i8/5)+(4 *(j8-3))%(i8+j8-2))>=10);//El resultat es vertader.
        //z) (i – 3 * j) % (c + 2 * d) / (x – y) >= 0
        System.out.println((i8-3*j8)%(c8+2*d8)/(x8-y8)>=0);//El resultat es fals.

    }
}