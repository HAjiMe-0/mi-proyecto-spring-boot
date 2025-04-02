## Funcionalidades de la aplicación con respecto a Estudiante

La aplicación proporciona una API REST para gestionar estudiantes. A continuación se describen las funcionalidades disponibles:

### Obtener todos los estudiantes
- **Endpoint:** `GET /api/estudiantes`
- **Descripción:** Obtiene una lista de todos los estudiantes.
- **Respuesta:** `200 OK` con una lista de `EstudianteDTO`.

### Crear un nuevo estudiante
- **Endpoint:** `POST /api/estudiantes`
- **Descripción:** Crea un nuevo estudiante.
- **Cuerpo de la solicitud:** Un objeto `EstudianteDTO` con los datos del estudiante.
- **Respuesta:** `201 Created` con el `EstudianteDTO` creado.

### Actualizar un estudiante existente
- **Endpoint:** `PUT /api/estudiantes/{id}`
- **Descripción:** Actualiza los datos de un estudiante existente.
- **Parámetros de la ruta:** `id` del estudiante a actualizar.
- **Cuerpo de la solicitud:** Un objeto `EstudianteDTO` con los nuevos datos del estudiante.
- **Respuesta:** `200 OK` con el `EstudianteDTO` actualizado.

### Eliminar un estudiante
- **Endpoint:** `DELETE /api/estudiantes/{id}`
- **Descripción:** Elimina un estudiante existente.
- **Parámetros de la ruta:** `id` del estudiante a eliminar.
- **Respuesta:** `204 No Content` si la eliminación es exitosa.