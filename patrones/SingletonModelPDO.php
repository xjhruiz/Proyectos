<?php 
//PDO y singleton
class ModelPDOSingleton extends Config{
	private $db;
	private $filas = array();
	private static $instancia;
	//Constructor patronSingleton privado evita la creación de objetos fuera de la clase
	private function __construct (){
		$dbhost=(Config::$mvc_bd_hostname);
		$dbname=Config::$mvc_bd_nombre;
		$dbuser=Config::$mvc_bd_usuario;
		$dbpass=Config::$mvc_bd_clave;
		try{
			//buenas prácticas
			/*$this-> db= new PDO("mysql:host={$dbhost};dbname={$dbname};port=33065;charset=utf8",$dbuser,$dbpass);*/
			$this-> db= new PDO("mysql:host=".$dbhost.";dbname=".$dbname.";charset=utf8",$dbuser,$dbpass);
		}catch(PDOException $e){
			die("¡Error en la conexion ! " .$e->getMessage());
		}
	}
	//método singleton que crea instancia si no está creada
	public function singleton(){
		if(!isset(self::$instancia)){
			$miclase=__CLASS__;
			self::$instancia= new $miclase;
		}
		return self::$instancia;
	}
	// Evita que el objeto se pueda clonar
	public function __clone(){
		trigger_error('La clonación de este objeto no está permitida', E_USER_ERROR); 
	}
	// Cierra conexión asignándole valor null
	public function __destroy(){
		$this->db=null;
	}
	
	//Dame alimentos con una consulta preparada 
	//Ejecuta consulta y devuelve array de resultados o NULL sí falla ejecución
	public function dameAlimentosPDO(){
         $sql = "select * from alimentos order by energia desc";
		//PDO
		try{ 
		//buenas prácticas usar $this->db->query($sql) --> consultas sin filtro "puros select"
		$consulta = $this->db->prepare($sql);
		$consulta->execute();
			if($consulta!== false){
				$consulta->setFetchMode(PDO::FETCH_ASSOC);
				while($row=$consulta->fetch()){
					$this->filas[]=$row;
				}
			}
		 } catch (PDOException $e){
			die("Error al ejecutar la orden :" . $e->getMessage());
		} 
			return $this->filas;
     }
	 //consulta preparada marcado posición -->?  marcado nombre :variable
	 public function buscarAlimentosPorNombrePDO($nombre){
         $nombre = htmlspecialchars($nombre);
		  //******** PDO **********
		  try{
			  //Marcadores de posición
			  //$sql = "select * from alimentos where nombre like ? order by energia desc";
			  //Marcadores de nombre good \*_*/
			  $buscarpor="%$nombre%";
			  $sql = "select * from alimentos where nombre like :nom order by energia desc";
			  $consulta = $this->db->prepare($sql);
			  //poner bindParam eso comprueba el parámetro recibido
			  $consulta->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
			  $consulta->bindParam('nom',$buscarpor,PDO::PARAM_STR);
			 // $consulta ->execute(['nom'=>$buscarpor]);
			 $consulta ->execute();
			  if($consulta!== false){
				$consulta->setFetchMode(PDO::FETCH_ASSOC);
				while($row=$consulta->fetch()){
					$this->filas[]=$row;
				}
			}
         
		  }catch(PDOException $e){
			  die("Error al ejecutar la orden :" . $e->getMessage());
		  }
		  return $this->filas;
     }
	public function dameAlimentoPDO($id){
         $id = htmlspecialchars($id);
         $sql = "select * from alimentos where id=:id ";
         /*$result = mysqli_query($this->conexion, $sql);
         $row = mysqli_fetch_assoc($result);
         return $row;*/
		 try{
		 $consulta = $this->db->prepare($sql);
		 //poner bindParam eso comprueba el parámetro recibido
		  $consulta->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
		$consulta->bindParam('id',$id,PDO::PARAM_INT);
		 $consulta->execute();
		 $row = $consulta->fetch(PDO::FETCH_ASSOC);
		 }catch(PDOException $e){
			  die("Error al ejecutar la orden :" . $e->getMessage());
		  }
			return $row;
     }
	 public function insertarAlimentoPDO($n, $e, $p, $hc, $f, $g){
         $n = htmlspecialchars($n);
         $e = htmlspecialchars($e);
         $p = htmlspecialchars($p);
         $hc = htmlspecialchars($hc);
         $f = htmlspecialchars($f);
         $g = htmlspecialchars($g);

        /*  ***** MySQLi
		$sql = "insert into alimentos (nombre, energia, proteina,
                 hidratocarbono, fibra, grasatotal) values ('" .
                 $n . "'," . $e . "," . $p . "," . $hc . "," . $f . "," . $g . ")"; 
				 $result = mysqli_query($this->conexion, $sql);
		*/
			$sql= "insert into alimentos (nombre, energia, proteina, hidratocarbono, fibra, grasatotal) values(:nom,:e,:p,:hc,:f,:g)";
			/*
			Otra forma de introducir parametros en bindParam
			$sql= "insert into alimentos (nombre, energia, proteina, hidratocarbono, fibra, grasatotal) values(?,?,?,?,?,?)";
			$consulta->bindParam(1,$n, PDO::PARAM_STR);
			pongo el numero seguido del parametro
			*/
			try{
				$consulta = $this->db->prepare($sql);
				//poner bindParam eso comprueba el parámetro recibido
				 $consulta->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
			  $consulta->bindParam('nom',$n, PDO::PARAM_STR);
			   $consulta->bindParam('e',$e, PDO::PARAM_INT);
			    $consulta->bindParam('p',$p,PDO::PARAM_INT);
				 $consulta->bindParam('hc',$hc,PDO::PARAM_INT);
				  $consulta->bindParam('f',$f,PDO::PARAM_INT);
				   $consulta->bindParam('g',$g,PDO::PARAM_INT);
				$consulta->execute();
			}catch(PDOException $e){
				die("Error al ejecutar la orden :" . $e->getMessage());
			}
         return $consulta;
     }
	public function validarDatos($n, $e, $p, $hc, $f, $g)
     {
         return (is_string($n) &
                 is_numeric($e) &
                 is_numeric($p) &
                 is_numeric($hc) &
                 is_numeric($f) &
                 is_numeric($g));
     }
	 public function buscarPorKcalorias($kcl){
         $id = htmlspecialchars($kcl);
         $sql = "select * from alimentos where energia=:ener ";
		 try{
		 $consulta = $this->db->prepare($sql);
		 //poner bindParam eso comprueba el parámetro recibido
		 $consulta->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
		$consulta->bindParam('ener',$kcl, PDO::PARAM_INT);
		 $consulta->execute();
		$consulta->setFetchMode(PDO::FETCH_ASSOC);
			 while($row=$consulta->fetch()){
					$this->filas[]=$row;
				}
		 }catch(PDOException $e){
			  die("Error al ejecutar la orden :" . $e->getMessage());
		  }
			return $this->filas;
     }
	 public function loginPDO($nomb, $clave){
         $id = htmlspecialchars($nomb);
		 $id = htmlspecialchars($clave);
         $sql = "select * from usuarios where nombre = :nomb and clave = :clav ";
		 try{
		 $consulta = $this->db->prepare($sql);
		 //poner bindParam eso comprueba el parámetro recibido
		$consulta->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
		$consulta->bindParam('nomb',$nomb, PDO::PARAM_STR);
		$consulta->bindParam('clav',$clave, PDO::PARAM_STR);
		 $consulta->execute();
		 $row = $consulta->fetch(PDO::FETCH_ASSOC);
		 }catch(PDOException $e){
			  die("Error al ejecutar la orden :" . $e->getMessage());
		  }
			return $row;
     }
	 public function buscarPorKcaloriasSim($simb,$kcl){
         $id = htmlspecialchars($kcl);
         $sql = "select * from alimentos where energia".$simb.":ener";
		 try{
		 $consulta = $this->db->prepare($sql);
		 //poner bindParam eso comprueba el parámetro recibido
		 $consulta->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
		 $consulta->bindParam('ener',$kcl, PDO::PARAM_INT);
		 $consulta->execute();
		$consulta->setFetchMode(PDO::FETCH_ASSOC);
			 while($row=$consulta->fetch()){
					$this->filas[]=$row;
				}
		 }catch(PDOException $e){
			  die("Error al ejecutar la orden :" . $e->getMessage());
		  }
			return $this->filas;
     }
	 
	 public function eliminarAlimento($id){
		 $id = htmlspecialchars($id);
		  $exito=false;
		 $sql='delete from alimentos where id= :id';
		 try{
			 $consulta = $this->db->prepare($sql);
			 //poner bindParam eso comprueba el parámetro recibido
			 $consulta =setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
			 $consulta->bindParam('id',$id,PDO::PARAM_INT);
			 if($consulta->execute()==true)
			 $exito=true;
		 }catch(PDOException $e){
			 die("Error al ejecutar la orden :" . $e->getMessage());
		 }
		 return $exito;
	 }
	 //https://diego.com.es/tutorial-de-pdo
}





?>