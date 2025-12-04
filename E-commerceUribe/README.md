# E-Commerce Uribe - API REST

## 📋 Descripción

API REST completa para gestionar un sistema de comercio electrónico. Desarrollada con **Spring Boot 3.5.6** y **Java 17**, implementa operaciones CRUD para usuarios, clientes, empleados, productos y pedidos.

---

## 🚀 Inicio Rápido (IntelliJ)

### Requisitos
- Java 17+
- Maven 3.6+

### Opción 1: Ejecutar desde IntelliJ (Recomendado)

1. **Abrir el proyecto en IntelliJ**
   - File → Open → Seleccionar carpeta `E-commerceUribe`

2. **Esperar a que se indexe**
   - IntelliJ descargará las dependencias automáticamente

3. **Ejecutar la aplicación**
   - Click derecho en `ECommerceUribeApplication.java`
   - Seleccionar `Run 'ECommerceUribeApplication'`
   - O presionar `Shift + F10`

4. **Ver la consola**
   - La aplicación se ejecutará en `http://localhost:8080`

### Opción 2: Ejecutar desde Terminal

```bash
# En IntelliJ: Alt + F12 (abrir terminal)
mvn clean install
mvn spring-boot:run
```

### Acceder a la Aplicación
- **API:** http://localhost:8080
- **Swagger UI:** http://localhost:8080/docs
- **H2 Console:** http://localhost:8080/h2-console
  - Usuario: `sa`
  - Contraseña: `12`

---

## ⚙️ Configuración en IntelliJ

### Configurar JDK
1. File → Project Structure → Project
2. SDK: Seleccionar Java 17+
3. Language level: 17

### Configurar Maven
1. File → Settings → Build, Execution, Deployment → Build Tools → Maven
2. Maven home path: Dejar por defecto o especificar
3. Verificar que esté habilitado

### Plugins Recomendados
- Spring Boot (integrado)
- Lombok (si lo necesitas)
- Database Tools (para H2)

### Atajos Útiles en IntelliJ
- `Shift + F10` - Ejecutar aplicación
- `Ctrl + Shift + F10` - Ejecutar con debug
- `Alt + F12` - Abrir terminal
- `Ctrl + Alt + L` - Formatear código
- `Ctrl + Shift + O` - Optimizar imports

---

## 🏗️ Arquitectura

```
Controladores (REST API)
    ↓
Servicios (Lógica de Negocio)
    ↓
Repositorios (Acceso a Datos)
    ↓
Base de Datos (H2/MySQL)
```

---

## 📊 Modelos Principales

### 1. **Usuario**
- Entidad base del sistema
- Atributos: id, nombres, correo, contraseña, estado, documento
- Relaciones: OneToOne con Cliente y Empleado

### 2. **Cliente**
- Perfil de cliente para compras
- Atributos: dirección, calificación, departamento, ciudad
- Relaciones: OneToMany con Pedidos

### 3. **Empleado**
- Perfil de empleado
- Atributos: cargo, salario, sede

### 4. **Producto**
- Artículos del catálogo
- Atributos: nombre, precio, categoría, marca, descripción

### 5. **Pedido**
- Órdenes de compra
- Atributos: montoTotal, fechaCreación, fechaEntrega, costoEnvío
- Relaciones: OneToMany con Productos, ManyToOne con Cliente

---

## 🔌 Endpoints Principales

### Usuarios (`/api/usuarios`)
```
POST   /api/usuarios              → Crear usuario
GET    /api/usuarios              → Listar todos
GET    /api/usuarios/{id}         → Buscar por ID
PUT    /api/usuarios/{id}         → Actualizar
DELETE /api/usuarios/{id}         → Eliminar
```

### Clientes (`/api/clientes`)
```
POST   /api/clientes              → Crear cliente
GET    /api/clientes              → Listar todos
GET    /api/clientes/{id}         → Buscar por ID
PUT    /api/clientes/{id}         → Actualizar
DELETE /api/clientes/{id}         → Eliminar
GET    /api/clientes/departamento/{dept} → Buscar por departamento
```

### Productos (`/api/productos`)
```
POST   /api/productos             → Crear producto
GET    /api/productos             → Listar todos
GET    /api/productos/{id}        → Buscar por ID
PUT    /api/productos/{id}        → Actualizar
DELETE /api/productos/{id}        → Eliminar
GET    /api/productos/marca/{marca} → Buscar por marca
```

### Pedidos (`/api/pedidos`)
```
POST   /api/pedidos               → Crear pedido
GET    /api/pedidos               → Listar todos
GET    /api/pedidos/{id}          → Buscar por ID
PUT    /api/pedidos/{id}          → Actualizar
DELETE /api/pedidos/{id}          → Eliminar
GET    /api/pedidos/fecha/{fecha} → Buscar por fecha
```

### Empleados (`/api/empleados`)
```
POST   /api/empleados             → Crear empleado
GET    /api/empleados             → Listar todos
GET    /api/empleados/{id}        → Buscar por ID
PUT    /api/empleados/{id}        → Actualizar
DELETE /api/empleados/{id}        → Eliminar
```

---

## 📝 Ejemplos de Uso

### Crear Usuario
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombres": "Juan Pérez",
    "correo": "juan@example.com",
    "contraseña": "password123",
    "estado": "Activo",
    "fechaNacimiento": "1990-05-15",
    "tipoDocumento": "CC",
    "documento": "1234567890"
  }'
```

### Crear Cliente
```bash
curl -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{
    "direccion": "Calle 10 #20-30",
    "calificacion": 4.5,
    "referenciaPago": "REF123",
    "departamentoCliente": "Cundinamarca",
    "ciudad": "Bogotá",
    "usuario": {"id": 1}
  }'
```

### Crear Producto
```bash
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Camiseta Nike",
    "fotografia": "nike.jpg",
    "descripcion": "Camiseta deportiva",
    "categoriaProducto": "Camiseta",
    "precioUnitario": 89900,
    "marca": "Nike",
    "aplicaDescuento": true
  }'
```

### Crear Pedido
```bash
curl -X POST http://localhost:8080/api/pedidos \
  -H "Content-Type: application/json" \
  -d '{
    "montoTotal": 250000,
    "fechaCreacion": "2024-12-04",
    "fechaEntrega": "2024-12-08",
    "costoEnvio": 10000,
    "cliente": {"id": 1}
  }'
```

---

## 🗄️ Base de Datos

### Configuración (application.properties)
```properties
# H2 (Desarrollo)
spring.datasource.url=jdbc:h2:mem:uribedb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=12
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# MySQL (Producción) - Cambiar a esto
# spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_uribe
# spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# spring.datasource.username=root
# spring.datasource.password=tu_password
```

---

## 📦 Tecnologías

| Tecnología | Versión |
|-----------|---------|
| Java | 17 |
| Spring Boot | 3.5.6 |
| Spring Data JPA | Latest |
| H2 Database | Latest |
| MySQL | Latest |
| MapStruct | 1.5.4 |
| SpringDoc OpenAPI | 2.8.13 |
| Maven | Latest |

---

## 🔐 Características

✅ CRUD completo para 5 entidades principales

✅ Búsquedas especializadas (por marca, departamento, fecha)

✅ Documentación automática con Swagger/OpenAPI

✅ Mapeo de DTOs con MapStruct

✅ Relaciones JPA configuradas (OneToOne, OneToMany, ManyToOne)

✅ Validaciones de datos

✅ Transacciones en base de datos

✅ Manejo de errores HTTP

✅ Soporte H2 (desarrollo) y MySQL (producción)

✅ Arquitectura en capas escalable

---

## 📊 Relaciones de Datos

```
USUARIO (1) ──── (1) CLIENTE ──── (N) PEDIDO ──── (N) PRODUCTO
   │
   └─── (1) EMPLEADO
```

---

## 🛠️ Herramientas Disponibles

### Swagger UI
Interfaz interactiva para probar endpoints:
```
http://localhost:8080/docs
```

### Consola H2
Visualizar y gestionar la base de datos:
```
http://localhost:8080/h2-console
Usuario: sa
Contraseña: 12
```

### API Docs JSON
Especificación OpenAPI:
```
http://localhost:8080/api-docs
```

---

## 🐛 Debug en IntelliJ

### Ejecutar en Debug
1. Click derecho en `ECommerceUribeApplication.java`
2. Seleccionar `Debug 'ECommerceUribeApplication'`
3. O presionar `Ctrl + Shift + F10`

### Agregar Breakpoints
1. Click en el número de línea donde quieras pausar
2. Aparecerá un punto rojo
3. Ejecuta en debug y se pausará en ese punto

### Inspeccionar Variables
- Hover sobre variables para ver su valor
- Panel "Variables" en la parte inferior

### Consola de IntelliJ
- Ver logs en tiempo real
- Filtrar por nivel (INFO, ERROR, DEBUG)
- Buscar mensajes específicos

---

## 🧪 Testing en IntelliJ

### Ejecutar Tests
```bash
# Todos los tests
mvn test

# Test específico
mvn test -Dtest=NombreDelTest
```

### Desde IntelliJ
1. Click derecho en carpeta `test`
2. Seleccionar `Run 'Tests'`
3. O presionar `Ctrl + Shift + F10`

### Ver Cobertura
1. Run → Run with Coverage
2. IntelliJ mostrará qué código está cubierto

---

## 🎯 Enums Disponibles

**EstadosUsuario:** Activo, Inactivo

**TipoDocumento:** CC, CE, Pasaporte, NIT

**CategoriaProducto:** Camiseta, Pantalón, Vestido, Interior, Zapatos, Chaquetas, Polo, Bermuda, Accesorio, Electrónicos

**CargoEmpleado:** Gerente, Vendedor, Soporte, Administrativo

**SedeEmpleado:** Bogotá, Medellín, Cali, Barranquilla

**DepartamentoCliente:** Cundinamarca, Antioquia, Valle, Atlántico, Otros

---

## 📋 Flujo Típico de Compra

```
1. Crear Usuario (POST /api/usuarios)
2. Crear Cliente (POST /api/clientes) - Asociar usuario
3. Crear Productos (POST /api/productos)
4. Crear Pedido (POST /api/pedidos) - Asociar cliente
5. Ver Pedido (GET /api/pedidos/{id})
```

---

## 🐛 Troubleshooting

### Puerto 8080 en uso
```bash
# Cambiar puerto en application.properties
server.port=8081
```

### Error de conexión a BD
- Verificar que H2 esté habilitado
- O configurar correctamente MySQL

### Error de mapeo DTO
```bash
mvn clean install
```

---

## 📞 Información Rápida

| Recurso | URL |
|---------|-----|
| API Base | http://localhost:8080 |
| Swagger | http://localhost:8080/docs |
| H2 Console | http://localhost:8080/h2-console |
| API Docs | http://localhost:8080/api-docs |

---

## 📂 Estructura de Carpetas en IntelliJ

```
E-commerceUribe/
├── src/
│   ├── main/
│   │   ├── java/com/example/E_commerceUribe/
│   │   │   ├── ECommerceUribeApplication.java      ← Punto de entrada
│   │   │   ├── controladores/                      ← REST Controllers
│   │   │   ├── servicios/                          ← Lógica de negocio
│   │   │   ├── repositorios/                       ← Acceso a datos
│   │   │   ├── modelos/                            ← Entidades JPA
│   │   │   │   ├── DTO/                            ← Data Transfer Objects
│   │   │   │   └── mapas/                          ← Mappers
│   │   │   └── ayudas/                             ← Enums
│   │   └── resources/
│   │       └── application.properties              ← Configuración
│   └── test/
├── pom.xml                                         ← Dependencias Maven
└── README.md                                       ← Este archivo
```

### Navegar en IntelliJ
- `Ctrl + N` - Buscar clase por nombre
- `Ctrl + Shift + N` - Buscar archivo
- `Ctrl + F12` - Ver estructura del archivo
- `Alt + 1` - Ver árbol de proyecto
- `Ctrl + B` - Ir a definición

---

## 🔍 Buscar y Reemplazar en IntelliJ

### Buscar
- `Ctrl + F` - Buscar en archivo actual
- `Ctrl + H` - Buscar y reemplazar
- `Ctrl + Shift + F` - Buscar en todo el proyecto

### Ejemplos
- Buscar todas las referencias a una clase
- Buscar métodos sin usar
- Buscar TODO comments

---

## 💡 Tips para Desarrollar en IntelliJ

### Autocompletado
- `Ctrl + Space` - Autocompletado básico
- `Ctrl + Shift + Space` - Autocompletado inteligente
- `Ctrl + Alt + Space` - Autocompletado de clase

### Refactoring
- `Shift + F6` - Renombrar variable/método
- `Ctrl + Alt + M` - Extraer método
- `Ctrl + Alt + V` - Extraer variable

### Generación de Código
- `Alt + Insert` - Generar getters/setters
- `Ctrl + O` - Sobrescribir métodos
- `Ctrl + I` - Implementar métodos

### Inspecciones
- `Ctrl + Alt + I` - Ejecutar inspecciones
- Warnings en rojo/amarillo en el editor
- Sugerencias de mejora

---

## 🚨 Problemas Comunes en IntelliJ

### IntelliJ no reconoce las clases
```
Solución:
1. File → Invalidate Caches → Invalidate and Restart
2. O presionar Ctrl + Shift + A y buscar "Invalidate"
```

### Maven no descarga dependencias
```
Solución:
1. View → Tool Windows → Maven
2. Click en el icono de actualizar
3. O: mvn clean install en terminal
```

### Puerto 8080 en uso
```
Solución:
1. Cambiar puerto en application.properties
2. O matar el proceso: netstat -ano | findstr :8080
```

### Errores de compilación
```
Solución:
1. Build → Rebuild Project
2. O: Ctrl + F9
```

---

## ✅ Checklist

- ✅ CRUD Usuarios
- ✅ CRUD Clientes
- ✅ CRUD Empleados
- ✅ CRUD Productos
- ✅ CRUD Pedidos
- ✅ Búsquedas especializadas
- ✅ Documentación Swagger
- ✅ Mapeo de DTOs
- ✅ Relaciones JPA
- ✅ Base de datos H2/MySQL

---

## 📄 Licencia

Proyecto interno para E-Commerce Uribe

---

**Versión:** 1.0.0  
**Última actualización:** Diciembre 2024  
**Optimizado para:** IntelliJ IDEA
