-- Crear la tabla de EstadoSolicitud
CREATE TABLE EstadoSolicitud (
    NroEstadoSolicitud INT PRIMARY KEY,
    NombreEstadoSolicitud VARCHAR(255),
    -- Otros atributos relevantes
);

-- Crear la tabla de Servicio
CREATE TABLE Servicio (
    NroServicio INT PRIMARY KEY,
    NombreServicio VARCHAR(255),
    -- Otros atributos relevantes
);

-- Crear la tabla de Solicitud
CREATE TABLE Solicitud (
    NroSolicitud INT PRIMARY KEY,
    FechaSolicitud DATE,
    NroEstadoSolicitud INT,
    NombreSolicitante VARCHAR(255),
    FOREIGN KEY (NroEstadoSolicitud) REFERENCES EstadoSolicitud(NroEstadoSolicitud)
    -- Otros atributos relevantes
);

-- Crear la tabla de SolicitudServicio (tabla intermedia para la relación muchos a muchos)
CREATE TABLE SolicitudServicio (
    NroSolicitud INT,
    NroServicio INT,
    PRIMARY KEY (NroSolicitud, NroServicio),
    FOREIGN KEY (NroSolicitud) REFERENCES Solicitud(NroSolicitud),
    FOREIGN KEY (NroServicio) REFERENCES Servicio(NroServicio)
    -- Otros atributos relevantes
);
