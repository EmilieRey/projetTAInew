import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class BDD {

		Connection connexion;

		public BDD()
		{

			try
			{
				System.out.println("Chargement de pilote JDBC<-->MySQL  ...");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("pilote chargé.");

				String utilisateurBDD = "root"; // Utilisateur de la BD
				String motdepasseBDD = ""; // Password de l'utilisateur de la BDD
	            
				String nomBDD = "tairrbe"; // Nom de la BD sur laquelle nous allons accede	
				
				// pour mariadb, port par défaut (c'est le port 3306)			
				String urlBDD = "jdbc:mysql://localhost:3306/"+nomBDD; 
				
				// pour mysql, port 3308
				//String urlBDD = "jdbc:mysql://localhost:3308/"+nomBDD+"?useSSL=false";          

				// pour mamp			
				//String urlBDD = "jdbc:mysql://localhost:8889/"+nomBDD+"?useSSL=false";   


				try
				{
					connexion = DriverManager.getConnection(urlBDD, utilisateurBDD, motdepasseBDD);
					System.out.println("Connexion établie.");
				}

				catch (SQLException ex)
				{
					ex.printStackTrace();
				}
			}

			catch(ClassNotFoundException e)
			{
				System.out.println(e);
			}
		}

		public Connection getConnexion()
		{
			return connexion;
		}	

		public void fermerConnexion()
		{
			try
			{
				connexion.close(); 

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

