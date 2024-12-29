package com.jay.orchestration.mapper;

import com.jay.orchestration.dto.UserDTO;
import com.jay.orchestration.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper implements Function<UserDTO,User> {
    @Override
    public User apply(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMaidenName(userDTO.getMaidenName());
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setBirthDate(userDTO.getBirthDate());
        user.setImage(userDTO.getImage());
        user.setBloodGroup(userDTO.getBloodGroup());
        user.setHeight(user.getHeight());
        user.setWeight(userDTO.getWeight());
        user.setEyeColor(userDTO.getEyeColor());
        User.Hair hair = new User.Hair();
        hair.setColor(userDTO.getHair().getColor());
        hair.setType(userDTO.getHair().getType());
        user.setHair(hair);
        user.setIp(userDTO.getIp());

        User.Address address = new User.Address();
        address.setAddress(userDTO.getAddress().getAddress());
        address.setCity(userDTO.getAddress().getCity());
        address.setState(userDTO.getAddress().getState());
        address.setStateCode(userDTO.getAddress().getStateCode());
        address.setPostalCode(userDTO.getAddress().getPostalCode());
        address.setCountry(userDTO.getAddress().getCountry());

        address.setLat(userDTO.getAddress().getCoordinates().getLat());
        address.setLng(userDTO.getAddress().getCoordinates().getLng());

        user.setAddress(address);
        user.setMacAddress(userDTO.getMacAddress());

        //TODO : Set Other parameters of the entity from dto
        user.setUniversity(userDTO.getUniversity());
        User.Bank bank = new User.Bank();
        bank.setCardExpire(userDTO.getBank().getCardExpire());
        bank.setCardNumber(userDTO.getBank().getCardNumber());
        bank.setCardType(userDTO.getBank().getCardType());
        bank.setCurrency(userDTO.getBank().getCurrency());
        bank.setIban(userDTO.getBank().getIban());

        User.Company company = new User.Company();
        company.setDepartment(userDTO.getCompany().getDepartment());
        company.setName(userDTO.getCompany().getName());
        company.setTitle(userDTO.getCompany().getTitle());
        User.Address companyAddress = new User.Address();
        companyAddress.setAddress(userDTO.getCompany().getAddress().getAddress());
        companyAddress.setCity(userDTO.getCompany().getAddress().getCity());
        companyAddress.setState(userDTO.getCompany().getAddress().getState());
        companyAddress.setStateCode(userDTO.getCompany().getAddress().getStateCode());
        companyAddress.setPostalCode(userDTO.getCompany().getAddress().getPostalCode());
        companyAddress.setCountry(userDTO.getCompany().getAddress().getCountry());
        companyAddress.setLat(userDTO.getCompany().getAddress().getCoordinates().getLat());
        companyAddress.setLng(userDTO.getCompany().getAddress().getCoordinates().getLng());
        company.setAddress(companyAddress);


        user.setBank(bank);
        user.setCompany(company);
        user.setEin(userDTO.getEin());
        user.setSsn(userDTO.getSsn());
        user.setUserAgent(userDTO.getUserAgent());

        User.Crypto crypto = new User.Crypto();
        crypto.setCoin(userDTO.getCrypto().getCoin());
        crypto.setWallet(userDTO.getCrypto().getWallet());
        crypto.setNetwork(userDTO.getCrypto().getNetwork());
        user.setCrypto(crypto);

        user.setRole(userDTO.getRole());

        return user;
    }
}
