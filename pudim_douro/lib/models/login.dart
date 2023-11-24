import 'package:flutter_login/flutter_login.dart';

class Login {
  final String email;
  final String password;

  Login(
    this.email,
    this.password,
  );

  @override
  String toString() {
    return 'Login{email: $email, password: $password}';
  }

  Login.fromJson(Map<String, dynamic> json)
      : email = json['email'],
        password = json['password'];

  Login.fromLoginData(LoginData loginData)
      : email = loginData.name.toString(),
        password = loginData.password.toString();

  Map<String, dynamic> toJson() => {
        'email': email,
        'password': password,
      };
}
