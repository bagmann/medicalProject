package ge.tsu.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ge.tsu.shared.*;

import java.util.List;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("appService")
public interface AppService extends RemoteService {

    void logout();

    void logToServer(Throwable th);

    void testMethod(String testParam);

    List<UserModel> loadUsers();

    UserModel saveUser(UserModel userModel) throws MedicException;

    void deleteUser(UserModel userModel);

    UserModel loadCurrentUser();

    void saveForm200a(UserModel userModel, BloodTransfusionModel transfusionModel, List<CustomerAllergyModel> customerAllergyModels, List<CustomerSurgeryModel> customerSurgeryModels, List<CustomerDiseaseModel> customerDiseaseModels, PoliceModel policeModel);

    List<AllergyModel> loadAllergies();

    List<SurgeryModel> loadSurgeries();

    List<DiseaseModel> loadDiseases(boolean chronicDisease);

    List<InsuranceCompanyModel> loadInsuranceCompanies();

    UserModel loadUser(UserModel userModel);

    void changePassword(long currentUserId, String newPassword);

    /**
     * Utility class to get the RPC Async interface from client-side code
     */
/*	public static final class Util {
        private static AppServiceAsync instance;

		private Util() {
			// Utility class should not be instanciated
		}

		public static final AppServiceAsync getInstance() {
			if (instance == null) {
				instance = (AppServiceAsync) GWT.create(AppService.class);
			}
			return instance;
		}
	}*/

    public static class Util {
        private static AppServiceAsync instance;

        public static AppServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(AppService.class);
            }
            return instance;
        }
    }
}
