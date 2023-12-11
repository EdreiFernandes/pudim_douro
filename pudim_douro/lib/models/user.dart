class User {
  final String email;
  final String name;
  final String surname;
  final String nickname;
  final String? password;
  final bool active;

  User(
    this.email,
    this.name,
    this.surname,
    this.nickname,
    this.password,
    this.active,
  );

  @override
  String toString() {
    return 'User{email: $email, name: $name, surname: $surname, nickname: $nickname, password: $password, active: $active}';
  }

  User.fromJson(Map<String, dynamic> json)
      : email = json['email'],
        name = json['name'],
        surname = json['surname'],
        nickname = json['nickname'],
        password = json['password'],
        active = json['active'];

  Map<String, dynamic> toJson() => {
        'email': email,
        'name': name,
        'surname': surname,
        'nickname': nickname,
        'password': password,
        'active': active,
      };
}
