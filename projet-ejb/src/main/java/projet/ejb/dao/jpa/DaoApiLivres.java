package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.commun.dto.DtoLivre;
import projet.ejb.dao.IDaoApiLivres;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.data.Compte;
import com.fasterxml.jackson.databind.ObjectMapper;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoApiLivres implements IDaoApiLivres {
	final static String NY_API_KEY = "n6RRK59oCG9F0PA8u0fG2vNvEuILEE9Z";
	final static String NY_API_URL = "https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key="+NY_API_KEY;
	@Override
	public ResponseApiNY getNYApiBooks() {
		try {
			ResponseApiNY response = getLivresNyApi();
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResponseApiNY getLivresNyApi() throws IOException {
        // Créer la connexion HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) new URL(NY_API_URL).openConnection();

        // Configuration de la connexion
        connection.setRequestMethod("GET");

        // Récupération de la réponse de la requête
        int responseCode = connection.getResponseCode();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseApiNY responseNY = objectMapper.readValue(response.toString(), ResponseApiNY.class);
        return responseNY;
    }

}

