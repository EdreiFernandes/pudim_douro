import 'dart:convert';

import 'package:http/http.dart';
import 'package:pudim_douro/http/webclient.dart';
import 'package:pudim_douro/models/user.dart';

class UserWebClient {
  Future<List<User>> test() async {
    final Response response =
        await client.get(baseUrl).timeout(const Duration(seconds: 5));

    final List<dynamic> decodedJson = jsonDecode(response.body);
    return decodedJson.map((dynamic json) => User.fromJson(json)).toList();
  }
}
