=============================================================================================================================================================
Máster en Software Craftsmanship. Módulo Experto en Aseguramiento de la Calidad del Software (EACS). Extreme programing. Memoria de la Práctica.
=============================================================================================================================================================

:Autor: Antonio Camas Maestre
:git: https://github.com/antoniocamas/intervalHierarchy-tdd/


Evolucion del codigo de produccion
==================================

Durante el desarrollo del codigo con la tecnica de TDD se ha pasado por:

 - Una jerarquia en la clases interval y con especializaciones segun el tipo de intervalo,
 - Tener todo el codigo en una sola clase
 - Tener una jerarquia de objetos de tipo EndPoint
 - Diseño final sin jerarquía algua y reduciendo el código duplicado.
      

Código de producción
====================

Dos clases, Interval y EndPoint. Explotan la simetría del problema para no incurrir en codigo repetido.

Apalacándonos en esta simetría no es necesara una jerarquía en EndPoint ni Interval.

Solo hay un metodo en todo el codigo que realmente compara numeros. 

.. code:: java

  public boolean isLeft(EndPoint point) {
    if (this.isAnyOpen(point)) {
    return this.value < point.value;
    }
    return this.value <= point.value;

El resto the comparaciones excepto la de equidad están expresadas en base a esta evitando así el codigo repetido.


Tests
=======

253 test cases pasando.

Se usa la herencia para multiplicar los casos de prueba por el numbero de tipos de intervalo.

La clase IntervalTest tiene los test comunes y el resto de clases los casos particulares segun el tipo de intervale.

Cada test que se incluya en la clase Interval se multiplica por 12.

En todos los commits están todos los casos de prueba pasando.
