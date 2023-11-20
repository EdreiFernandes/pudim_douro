import 'package:flutter_login/flutter_login.dart';

class Login {
  final String email;
  final String password;
  final String token;

  Login(
    this.email,
    this.password,
    this.token,
  );

  @override
  String toString() {
    return 'Login{email: $email, password: $password, token: $token';
  }

  Login.fromJson(Map<String, dynamic> json)
      : email = json['email'],
        password = json['password'],
        token = json['token']; 

  Login.fromSignupData(SignupData signupData)
      : email = signupData.name.toString(),
        password = signupData.password.toString(),
        token = (signupData.additionalSignupData?["Token"]).toString();

  Map<String, dynamic> toJson() => {
        'email': email,
        'password': password,
        'token': token,
      };
}
