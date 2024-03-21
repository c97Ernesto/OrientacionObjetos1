<h1 align="center">Programación Orientada a Objetos 1</h1>

## [Ejercicios Prácticos](Practica#ejercicios-prácticos)

## Que es la Programación Orientada a Objetos?
La POO es un paradigma de programación que se basa en la idea de que el mundo está compuesto por **objetos** interconectados. Cada objeto tiene **atributos** (propiedades) y **métodos** (comportamientos). La POO nos permite modelar problemas del mundo real de manera más natural y estructurada.
El código es organizado en **unidades denominadas clases**, de las cuales se crean **objetos** que se relacionan entre sí para lograr los objetivos de las apliaciones.

### Pilares de la Programación Orientada a Objetos
Está basada en cuatro pilares, conceptos que la  diferencian de otros paradigmas de la programación.

### Abstracción
Muchas veces cuando se crea un programa con POO, se moldean los objetos del programa basandose en objetos del mundo real. Sin embargo, los objetos del programa no representan la originalidad del objeto en un 100% (dificilmente se haga). 

En cambio, éstos objetos solo modelan atributos y comportamientos de objetos reales en un contexto específico, ignorando el resto.

La **Abstracción** es un modelo de un objeto o fenómeno del mundo real, limitado a un contexto específico, el cual representa todo los detalles relevantes para este contexto con alta precisión obviando el resto.

### Encapsulamiento
El **encapsulamiento** es la capacidad de un objeto de **ocultar parte de su estado y comportamiento** a otros objetos, exponiendo solo una interfaz limitada al resto.

  - Basado en la idea de que **una clase debe controlar el acceso a sus propios datos internos.**
  - Para ésto se utilizan **[modificadores de acceso](#modificafores-de-acceso)** como `private`, `public`, `protected`.

#### Ejemplo 1:
Suponiendo que tenemos la clase `CuentaBancaria` y queremos encapsular los datos relacionados con una cuenta bancaria, como el saldo y el número de cuenta.

```java
public class CuentaBancaria {
    private int numeroCuenta; // Atributo privado
    private double saldo; // Atributo privado

    // Constructor
    public CuentaBancaria(int numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Cantidad no válida para depósito.");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Cantidad no válida para retiro o saldo insuficiente.");
        }
    }

    // Método para obtener el saldo actual
    public double obtenerSaldo() {
        return saldo;
    }
}

```

- Los atributos `numeroCuenta` y saldo están marcados como `private`, lo que significa que solo se pueden acceder dentro de la propia clase `CuentaBancaria`.

- Los métodos `depositar`, `retirar` y `obtenerSaldo` son públicos y proporcionan algo parecido a una interfaz para interactuar con los datos encapsulados.

#### Ejemplo 2: Usando Interface.
```java
// Definición de la interfaz Figura
interface Figura {
    double calcularArea();
}

// Clase Círculo que implementa la interfaz Figura
class Circulo implements Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

public class Main {
    public static void main(String[] args) {
        Circulo c = new Circulo(5.0);
        double areaCirculo = c.calcularArea();

        System.out.println("Área del círculo: " + areaCirculo);
    }
}

```

- La interfaz `Figura` define un método `calcularArea()`.
- La clase `Circulo` implementa esta interfaz y proporciona su propia implementación del método `calcularArea()`.
- El atributo `radio` está encapsulado dentro de la clase `Circulo`.

El uso de interfaces permite lograr el encapsulamiento y la abstracción al mismo tiempo, además de poder crear otras clases (`Triangulo`, `Rectangulo`, etc) que también implementen la interfáz `Figura` para proporionar sus propieam implementaciones del método `calcularArea()`.


### Herencia
La **herencia** en **programación orientada a objetos (POO)** nos permite crear **clases derivadas** a partir de una **clase padre**. La **clase hija hereda los atributos (propiedades) y métodos (comportamiento) de su clase padre**, lo que es de gran ayuda en la **reutilización de código** y establecer relaciones jerárquicas entre ellas.

#### Ejemplo 1

Supongamos que estamos creando una aplicación de animales en la que queremos modelar diferentes tipos de animales. Utilizaremos herencia en Java para definir una clase base llamada `Animal` y luego crearemos clases hijas como `Perro`, `Gato` y `Pájaro`.

```java
// Clase base (superclase) Animal
class Animal {
    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }
}

// Clase hija (subclase) Perro
class Perro extends Animal {
    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    public void ladrar() {
        System.out.println("¡Guau guau!");
    }
}

// Clase hija (subclase) Gato
class Gato extends Animal {
    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    public void maullar() {
        System.out.println("¡Miau miau!");
    }
}

// Clase hija (subclase) Pájaro
class Pajaro extends Animal {
    public Pajaro(String nombre, int edad) {
        super(nombre, edad);
    }

    public void volar() {
        System.out.println("Volando alto...");
    }
}

public class Main {
    public static void main(String[] args) {
        Perro miPerro = new Perro("Scooby", 3);
        miPerro.comer();
        miPerro.ladrar();

        Gato miGato = new Gato("Garfield", 2);
        miGato.comer();
        miGato.maullar();

        Pajaro miPajaro = new Pajaro("Golondrina", 1);
        miPajaro.comer();
        miPajaro.volar();
    }
}
```

- La clase `Animal` es la clase base (padre) con atributos en común (`nombre` y `edad`).
- Las clases `Perro`, `Gato` y `Pajaro` heredan (son subclases) de `Animal` y también tienen sus propios métodos (`ladrar`, `maullar`, `volar`).


#### Ejemplo 2: usando Interface.

- Las interfaces son una forma de lograr herencia múltiple en Java, permiten compartir comportamiento en común entre las diferentes clases sin restringir la jerarquía de herencia. 
- Cada clase puede implementar múltiples interfaces, lo que brinda flexibilidad y extensión al diseño del sistema.


```java
// Definición de la interfaz Vehiculo
interface Vehiculo {
    void acelerar();
    void frenar();
}

// Clase concreta Auto que implementa Vehiculo
class Auto implements Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("El auto está acelerando.");
    }

    @Override
    public void frenar() {
        System.out.println("El auto está frenando.");
    }
}

// Clase concreta Bicicleta que implementa Vehiculo
class Bicicleta implements Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("La bicicleta está pedaleando.");
    }

    @Override
    public void frenar() {
        System.out.println("La bicicleta está frenando con los frenos manuales.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehiculo miAuto = new Auto();
        miAuto.acelerar();
        miAuto.frenar();

        Vehiculo miBicicleta = new Bicicleta();
        miBicicleta.acelerar();
        miBicicleta.frenar();
    }
}
```

- La interfaz `Vehiculo` define los métodos: `acelerar()` y `frenar()`.
- Las clases `Auto` y `Bicicleta` implementan esta interfaz y hacen sus propias implementaciones de los métodos.


#### Modificafores de Acceso: 
Los modificadores de acceso son una herramienta clave para un programador Java, ya que le permiten controlar qué partes de una clase son visibles para el resto del programa. Esto significa que los programadores pueden restringir el acceso a los atributos y métodos de un objeto, y así proteger la integridad de los datos de los objetos. 

Los modificadores de acceso Java se clasifican en **cuatro tipos** principales:
- **Público:** Estos elementos se pueden acceder desde cualquier parte del programa.
- **Protegido:** Estos elementos se pueden acceder desde la clase en la que se definen y desde todas las subclases.
- **Defecto:** Estos elementos solo se pueden acceder desde la clase en la que se definen.
- **Privado:** Estos elementos solo se pueden acceder desde la clase en la que se definen.