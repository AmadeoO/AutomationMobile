package dataModels;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config;

@Sources("file:src/main/resources/userMobile.config")
public interface UserConfig extends Config {

    @Key("user.name")
    String userName();

    @Key("user.lastName")
    String userLastName();

    @Key("user.nationality")
    String userNationality();

    @Key("user.dni")
    String userDni();

    @Key("user.gender")
    String userGender();

    @Key("user.birthDate")
    String userBirthDate();

    @Key("user.addressBranchOffice")
    String userAddressBranchOffice();

    @Key("user.mail")
    String userMail();

    @Key("user.area")
    String userArea();

    @Key("user.phone")
    String userPhone();

    @Key("user.codeForSms")
    String userCodeForSms();

    @Key("user.locality")
    String userLocality();

    @Key("user.street")
    String userStreet();

    @Key("user.streetNumber")
    String userStreetNumber();

    @Key("user.floorNumber")
    String userFloorNumber();

    @Key("user.apartmentNumber")
    String userApartmentNumber();

    @Key("user.maritalStatus")
    String userMaritalSatus();
}
