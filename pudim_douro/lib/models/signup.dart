import 'package:flutter_login/flutter_login.dart';

class Signup {
  final String email;
  final String name;
  final String password;
  final String token;

  Signup(
    this.email,
    this.name,
    this.password,
    this.token,
  );

  @override
  String toString() {
    return 'Signup{email: $email, name: $name, password: $password, token: $token}';
  }

  Signup.fromJson(Map<String, dynamic> json)
      : email = json['email'],
        name = json["name"],
        password = json['password'],
        token = json['token'];

  Signup.fromSignupData(SignupData signupData)
      : email = signupData.name.toString(),
        name = (signupData.additionalSignupData?["Name"]).toString(),
        password = signupData.password.toString(),
        token = (signupData.additionalSignupData?["Token"]).toString();

  Map<String, dynamic> toJson() => {
        'email': email,
        'name': name,
        'password': password,
        'token': token,
      };
}
