package principal;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConexionDao;
import dao.AnimalDao;
import objetos.Animal;

/**
 * Servlet implementation class ConsultaAnimal
 * Servlet que gestiona los datos de la base de datos
 * @see dao.ConexionDao ,dao.AnimalDao, objetos.Animal
 */
@WebServlet("/ConsultaAnimal")
public class ConsultaAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**
 * Metodo para mostrar los datos de la base de datos
 * @see objetos.AnimalDao
 *
 */
    public ConsultaAnimal() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConexionDao con= new ConexionDao();
		AnimalDao.conexion=con.getConexion();
		String numero=request.getParameter("numero");
		int num=0;
		if(numero!=null){
				num=Integer.valueOf(numero);
				Animal ani=AnimalDao.consultaAnimalxid(num);
		if (ani!=null){
			request.setAttribute("animal", ani);
		}else{
			request.setAttribute("mensaje", "Animal no encontrado");
		}
		}
		RequestDispatcher dispatcher=
				getServletContext().getRequestDispatcher("/consultaanimal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
