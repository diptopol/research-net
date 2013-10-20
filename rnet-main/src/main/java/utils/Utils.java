package utils;

import domain.Collaborator;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/8/13
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public static boolean isJoiningDateRemains(Date startTime) {
        Date today = Calendar.getInstance().getTime();
        if(today.before(startTime))
            return true;
        else return false;
    }

    public static boolean isNotACollaborator(int userId, List<Collaborator> collaboratorList) {

        boolean isNotACollaborator = true;
        for(Collaborator collaborator: collaboratorList) {
            int collaborator_user_id = collaborator.getUser().getUserId();
            if(collaborator_user_id == userId) {
                isNotACollaborator = false;
                break;
            }
        }
        return isNotACollaborator;
    }




    public static Date getSystemDate() {
        return Calendar.getInstance().getTime();
    }


}
