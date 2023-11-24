import 'dart:convert';

import 'package:flutter_session_manager/flutter_session_manager.dart';
import 'package:http/http.dart';
import 'package:pudim_douro/http/webclient.dart';
import 'package:pudim_douro/models/scoreboard_line.dart';

class ScoreboardWebClient {
  Future<List<ScoreboardLine>> getScoreboard() async {
    final Response response = await client.get(scoreboardUrl).timeout(defaultTimeout);

    final List<dynamic> decodedJson = jsonDecode(response.body);
    List<ScoreboardLine> scoreboard = decodedJson
        .map((dynamic json) => ScoreboardLine.fromJson(json))
        .toList();
    if (response.statusCode == 200) {
      await SessionManager().set("scoreboard", response.body);
    }

    return scoreboard;
  }
}
