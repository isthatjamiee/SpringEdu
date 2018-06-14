package com.kh.myapp.login.vo;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class SecurityLoginVO_old {
	
	@Pattern(regexp="^[\\w=\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="이메일 형식이 아닙니다.")
	private String username; //alt + shift + R??? 선택단어 전체 바꿈 
	@Size(min=4, max=30, message="비밀번호는 4~30자리로 입력해주세요.")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginVO [username=" + username + ", password=" + password + "]";
	}

	
}
