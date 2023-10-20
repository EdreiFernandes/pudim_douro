class User {
  final String email;
  final String name;
  final String password;
  final bool active;

  User(
    this.email,
    this.name,
    this.password,
    this.active,
  );

  @override
  String toString() {
    return 'User{email: $email, name: $name, password: $password, active: $active';
  }

  User.fromJson(Map<String, dynamic> json)
      : email = json['email'],
        name = json['name'],
        password = json['password'],
        active = json['active'];

  Map<String, dynamic> toJson() => {
        'email': email,
        'name': name,
        'password': password,
        'active': active,
      };
}
