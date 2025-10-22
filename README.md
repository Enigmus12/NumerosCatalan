# NumerosCatalan
Una para calcular los números de Catalan desde C0​ hasta Cn​: catalan(n) retorna un JSON con la lista C0​,…,Cn​. (Recibe solo enteros no negativos).


1. Primero se debe de instalar java 17 en las instancias con este comando

    * sudo yum install java-17-amazon-corretto-headless

2. Despues se instala maven para compilar el proyecto

    * sudo yum install maven

3. Por ultimo se instala git para poder hacer al repositorio y clonarlo

    * sudo yum install git

4. Una vez instalado todo podemos clonar el repo

    * https://github.com/Enigmus12/NumerosCatalan.git

5. Una vez clonado accedemos a cd Proxi y compilamos y corremos

    * mvn clean install
    * mvn spring-boot:run    

6. Ahora accedemos a cd Catalan para correr la funcion matematica, y compilamos y corremos

    * mvn clean install
    * mvn spring-boot:run  

7. Por ultimo en la ultima instancia debemos de acceder a apllication.properties para cambiar el puerto a 8082 y una vez echo eso podemos compilar y correr

    * mvn clean install
    * mvn spring-boot:run  

8. En el video se muestra que funciona, si no se logra descaragr esta en el correo del profesor Benavides 