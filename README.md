# TMDb

## Capas de la aplicación:

### base:
  Aqui se encuentran clases Java que pueden heredarle sus metodos a otras Activity o Fragment, sirven como archvios
  base tanto para Activitys como Fragments y se usan para poder mostrar u ocultar por ejemplo mensajes de error al usuario sin tener que declarar
  los metodos en cada activity o fragment, simplemente hay que implementar el archivo necesario en las Activity o Fragment
  
  _Clases:_ BasicActivity, BasicFragment, BasicUIPresenter
  
  _Interfaces:_ BasicUIView, BasicView, BasicUIListener 

### ciruclarrevelation:
  Es un elemnto que nos permite crear una animación al momento de abrir un nuevo fragment o activity
  
  _Clases:_ MyCircularRevelation
  
### data:
  Esta es la capa que se encarga de manejar los datos que entran y se almacenan en la app, en ella podemos encontrar los modulos de Retrofit
  como el RetrofitClient y el ApiEndpoint que nos sirven para realizar las consultas al WS, de igual manera se encuetra el modulo de Room
  para la persisntencia de datos dentro de la app y los metodos Asyncronos para almacenar, leer y eliminar datos de la base de datos de Room.
  
  _Modulos:_
 
    async:
    
      Clases: AsyncMethods
      
    network:
    
      Clases: RetrofitClient
      Interface: ApiEndpoint
      Model: MoviesResponse, VideoResponse 
      
    room:
    
      dao: MoviesDAO
      db: AppDB
      entity: MoviesEntity 
  

### ui:
  Esta capa contiene todo lo referente a la ui de la app, se encuentrna los paquetes de cada modulo como SplashScreen y los fragmentos
  de cada categoria de peliculas, asi como los adaptadores y elementos custom como los dialogos personalizados.
  
  _Modulos:_
 
    adapter:
    
      Clases: MoviesAdapter, SectionPagerAdapter
      
    custom:
    
      Clases: ErrorDialog
      Interface: ApiEndpoint
      Model: MoviesResponse, VideoResponse 
      
    fragmentcoming, fragmentpopular, fragmenttop,main, moviedetail, splash:
      Todos incluyen 3 carpetas (model, view, presenter), en cada una se encuenta la misma estructura
      
      Clase: Model, Presenter, View (de cada modulo)
      Interface: View, Presenter, Listener, Model (de cada modulo)

### utils:
 En esta capa se encuentran metodos generales que pueden ser usados desde cualquier parte de la app, por ejemplo, se encuetra el archivo
 AppConstants que contiene las constantes que se usan en la app (BASE_URL, TAG, API_KET, etc...), el archivo AppConfig que se encarga de 
 retornarnos valores como los strings para los mensajes de error en la app, Utils que es un archivo con metodos generales.
 
 _Clases:_ AppConfig, AppConstants, Utils
 
 
 
## Preguntas:
 ### ¿En que consiste el principio de responsabilidad unica?
  Se refiere a que cada modulo o clase del proyecto de software debe tener responsabilidad sobre una sola parte de la funcionalidad
 ### ¿Cual es su proposito?
  Mantener una buena estructura en el proyecto y que este sea mas facil de modicificar y de esta forma si llegase a requerir algun cambio ya 
  sea agregar o quitar algo, esto solo afecte directamente a su modulo, mas no a otros
### ¿Que caracteristicas tiene un buent código?
  Debe estar organizado en modulos los cuales cada uno representen una funcionalidad de la app (dividir el problema en partes pequeñas para su mejor majeo),
  debe tener la capacidad de reutilizar codigo, cuando una tarea se repite constantemente en todo el proyecto, es bueno poder tener una clase en la cual se
  encuentre el metodo y este pueda ser reutilizado desde cualquier parte del proyecto, debe seguir las buenas practicas como la forma en que se nombran los 
  archivos, metodos, variables, el nombre de sus metodos y variables a mi parecer debe hacer referencia a las acciones que va realizar, por ejemplo: si se 
  va consumir un  WS para obtener los datos del usuario, a ese metodo lo llamaria: "getUserData", el codigo debe estar identado para tener una mejor comprención,
  en un buen codigo se deben comentar los algoritmos que sean complicados para que sea comprensible para los demás o para uno mismo en el futuro.
  
