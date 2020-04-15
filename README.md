# ENUNCIADO DE LA PRÁCTICA DE LA ASIGNATURA DE INTELIGENCIA ARTIFICIAL Y SISTEMAS INTELIGENTES 2019/2020

### :video_game: 14 puzzle

Se pide diseñar e implementar un sistema relacionado con los movimientos en un tablero de 4 x 4,
que se da como parámetro de entrada, y conseguir como salida un tablero ordenado de números. El
tablero de entrada podrá ser diferente en cada caso, aunque el tamaño es siempre de 4 x 4. Las
celdas tienen un valor asignado del 1 al 14 sin repetición y dos valores con 0, que representan los
huecos a donde se pueden mover los números. Se deben utilizar técnicas de búsquedas de forma que
proporcione una solución, consistente en indicar la secuencia de acciones (movimientos) desde el
tablero origen al tablero destino. Se parte desde el supuesto de que se dispone de muy poco tiempo
para encontrar la solución, por lo que interesa utilizar búsquedas con heurísticas, y se quiere
encontrar una solución que no tenga muchos movimientos.

#### :pencil: Aclaraciones:
- El fichero de entrada tendrá un formato de texto simple, de cuatro filas, y con los números
separados por comas. Se supone que el fichero de entrada estará siempre bien formado. No se
necesitan implementar funciones de comprobación.
- La secuencia de movimientos se indicarán en pantalla, indicando el número que se mueve, seguido
del movimiento (Norte, Sur, Este, Oeste).
- El tablero destino estará formado siempre con los números en orden, y las dos últimas posiciones
con los dos ceros.
- La matriz es “no circular”. Es decir, desde un borde no se accede a la otra parte de la matriz. Eso
significa que, por ejemplo el número 14 que está en el tablero origen no puede moverse hacia el Sur.

#### :books: Requisitos de la práctica:
- Los equipos de la práctica lo deben formar como máximo 3 alumnos.
- Se puede desarrollar en cualquier lenguaje de programación.
- Como mínimo, la práctica debe leer un fichero llamado PUZZLE.TXT , y mostrar como salida: la
técnica de resolución empleada, la secuencia de movimientos que forma la solución, el tiempo
empleado en la resolución y el número de nodos generados en memoria.
- La práctica debe intentar resolver el puzzle con, al menos, tres técnicas de resolución basadas en
resolución de problemas de inteligencia artificial, y deben hacerse pruebas con al menos 10 ficheros
de puzzles.
- Se debe entregar un ZIP con: los ficheros necesarios para ejecutar la aplicación, y la
documentación en un documento PDF con el formato que aparece en la plantilla de la práctica.
- Cualquier coincidencia en algoritmos, estructura, o enfoque de todo o en parte de los ficheros de
código fuente con otros grupos, implicará el suspenso de la asignatura en la parte práctica y teórica,
y de todos los miembros de los equipos implicados. Si se hubiera aprobado en una convocatoria
anterior, se podrá abrir un acta cerrada y generar un expediente.

#### :top: Mejoras aconsejadas (se pueden combinar):
- Hacer un tablero con más dimensiones.
- Incluir más de dos ceros para movimientos.
- Añadir movimientos en diagonal.
- Incluir casillas inmóviles (que no puedan hacer movimiento hacia un 0).

#### :100: Evaluación:
- Para sacar como mínimo un aprobado en la práctica, es obligatorio: (1) que estén implementados
al menos tres algoritmos de resolución, que muestren como salida la secuencia solución, tiempo y
nodos generados; y (2) que se entregue la documentación y ficheros fuente como se especifica en la
plantilla
- En la calificación, se tendrá en cuenta principalmente: la implementación de las técnicas de
resolución empleadas y las mejoras (70% aprox), y la calidad de la documentación (30% aprox).
- Si los equipos, en vez de tres miembros, lo forman dos, a la nota se le restará 0,5 puntos. Si lo
forma un solo miembro, se le restará 1 punto.
