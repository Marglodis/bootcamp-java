# ConsumirApi

Este proyecto en Java consume una API de geolocalización para obtener información sobre la ubicación de una dirección IP.

## Requisitos

- Java 11 o superior
- Maven (para gestionar las dependencias)
- Clave API de [IPBase](https://app.ipbase.com) (necesaria para hacer peticiones a la API)

## Configuración de la API Key

1. Crea una cuenta en [IPBase](https://app.ipbase.com) y obtén tu clave API.
2. **Opción 1: Usar Variables de Entorno**
    - En Linux/macOS:
        1. Abre la terminal y agrega esta línea a tu archivo `~/.bashrc` o `~/.zshrc`:
           ```bash
           export IPBASE_API_KEY="tu_clave_api"
           ```
        2. Ejecuta:
           ```bash
           source ~/.bashrc   # o source ~/.zshrc
           ```
    - En Windows:
        1. Abre el símbolo del sistema (CMD) y ejecuta:
           ```cmd
           setx IPBASE_API_KEY "tu_clave_api"
           ```

3. **Opción 2: Usar un archivo `.env`**
    - Crea un archivo llamado `.env` en la raíz del proyecto y agrega:
      ```ini
      IPBASE_API_KEY=tu_clave_api
      ```
    - Asegúrate de que el archivo `.env` esté en tu archivo `.gitignore` para evitar que se suba al repositorio.


