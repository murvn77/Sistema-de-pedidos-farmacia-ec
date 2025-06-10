# Sistema de Pedidos de Medicamentos - Java Swing

Este proyecto es una aplicación de escritorio desarrollada en **Java** utilizando la biblioteca **Swing** y el entorno de desarrollo **Eclipse**. Simula un sistema de pedidos de medicamentos de una farmacia a un distribuidor.

## 📌 Descripción

La aplicación permite registrar pedidos indicando:

- Nombre del medicamento.
- Tipo de medicamento (analgésico, anestésico, antibiótico, etc.).
- Cantidad solicitada.
- Distribuidor farmacéutico (Cofarma, Empsephar o Cemefar).
- Sucursal de la farmacia donde se enviará el pedido (principal y/o secundaria).

Incluye validación de campos y muestra una ventana de resumen antes de confirmar el pedido.

## 🧱 Arquitectura

Se aplicó el patrón **Modelo-Vista-Controlador (MVC)**:

- **Modelo:** Clase `Pedido`, que encapsula los datos del pedido.
- **Vista:** Interfaces gráficas desarrolladas con `Swing` (`FormPedido` y `ResumenPedido`).
- **Controlador:** Clase `PedidoController`, encargada de gestionar los eventos, validaciones y flujo entre modelo y vista.

## ⚙️ Requisitos Técnicos

- **IDE:** Eclipse
- **JDK:** Java 21
- **Compilación configurada para:**
  - `source = 21`
  - `targetPlatform = 21`
