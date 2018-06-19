package com.QA.Accounts;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class User {
	
	@Id @GeneratedValue
    private Long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
//    private @NonNull String accountNumber;
    
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//	public String getAccountNumber() {
//		return accountNumber;
//	}
//	public void setAccountNumber(String accountNumber) {
//		this.accountNumber = accountNumber;
//	}

    
}