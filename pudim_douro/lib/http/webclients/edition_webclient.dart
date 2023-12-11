import 'dart:convert';

import 'package:flutter_session_manager/flutter_session_manager.dart';
import 'package:http/http.dart';
import 'package:pudim_douro/http/webclient.dart';
import 'package:pudim_douro/models/edition.dart';

class EditionWebClient {
  Future<List<Edition>> getEditionHistory() async {
    final Response response = await client.get(editionUrl).timeout(defaultTimeout);

    final List<dynamic> decodedJson = jsonDecode(response.body);
    List<Edition> editionHistory =
        decodedJson.map((dynamic json) => Edition.fromJson(json)).toList();
    if(response.statusCode == 200){
      await SessionManager().set("history", response.body);
    }

    return editionHistory;
  }
}