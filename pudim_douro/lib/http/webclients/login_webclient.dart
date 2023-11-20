import 'dart:convert';

import 'package:flutter_session_manager/flutter_session_manager.dart';
import 'package:http/http.dart';
import 'package:pudim_douro/http/webclient.dart';
import 'package:pudim_douro/models/login.dart';
import 'package:pudim_douro/models/user.dart';

class LoginWebClient {
  Future<String?> signup(Login login) async {
    final String loginJson = jsonEncode(login.toJson());

    final Response response = await client.post(
      signupUrl,
      headers: {
        'Content-type': 'application/json',
      },
      body: loginJson,
    );

    if (response.statusCode == 201) return null;

    return Future.value(response.body);
  }

  Future<String?> login(Login login) async {
    final String loginJson = jsonEncode(login.toJson());

    final Response response = await client.post(
      loginUrl,
      headers: {
        'Content-type': 'application/json',
      },
      body: loginJson,
    );

    if (response.statusCode == 202) {
      User loggedUser = User.fromJson(jsonDecode(response.body));
      await SessionManager().set("user", loggedUser);
      return null;
    }

    return Future.value(response.body);
  }

  Future<User> test() async {
    final Response response =
        await client.get(userUrl).timeout(const Duration(days: 5));

    final List<dynamic> decodedJson = jsonDecode(response.body);
    return decodedJson
        .map((dynamic json) => User.fromJson(json))
        .toList()
        .first;
  }
}
