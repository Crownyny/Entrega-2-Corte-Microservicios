Hecho por:<br>
Mary Montenegro Cotacio<br>
Julian David Meneses Daza<br>

LINK DEL VIDEO: https://youtu.be/52ReGIJ7a90<br>
Este trabajo se hiso en base a los siguientes requisitos:<br>

Requisitos gestión artículos<br>
1) Yo como administrador quiero registrar un artículo para asociarlo a una conferencia.
2) Yo como administrador quiero consultar un artículo para ver sus detalles
3) Yo como administrador quiero listar todos los artículos para ver cuáles pueden ser mostrados en las
conferencias
4) Yo como administrador quiero actualizar un artículo para modificar su información
5) Yo como administrador quiero eliminar un artículo para no permitir que se muestre en las conferencias
6) Yo como administrador quiero consultar si existe un artículo para establecer si se puede registrar

Requisitos comunicación entre microservicios<br>
1) Yo como administrador quiero consultar los datos de un artículo y las conferencias en las cuales se
encuentra un artículo para ver sus detalles. Utilice una comunicación sincrona
2) Yo como administrador quero enviar correo los autores al registrar artículo para notificarlos. Utilice
una comunicación asíncrona con RabbitMQ. Por consola se debe mostrar la simulación del envio del
correo.

Requisitos gestión conferencia<br>
1) Yo como administrador quiero registrar una conferencia para que expositores puedan presentar sus
artículos.
2) Yo como administrador quiero listar las conferencias registradas para que expositores puedan ver en
cuales conferencias presentar sus artículos.
3) Yo como administrador quiero consultar si existe una conferencia para establecer si se pueden
registrar artículos
4) Yo como administrador quiero consultar la cantidad de artículos registrados en una conferencia para
ver si alcanzo su tope.
Interface grafica
Debe reutilizar las vistas creadas en la primera entrega. Las vistas utilizaran una clase que permita consumir los
servicios web creados.
