import 'package:http/http.dart';
import 'package:http_interceptor/http_interceptor.dart';
import 'package:pudim_douro/http/interceptors/logging_interceptor.dart';

final Client client = InterceptedClient.build(interceptors: [
  LoggingInterceptor(),
]);

const defaultTimeout = Duration(minutes: 1);

const String apiUrl = 'pudimdouroapi.onrender.com';

final Uri userUrl = Uri.https(apiUrl, '/api/user');
final Uri loginUrl = Uri.https(apiUrl, '/api/login');
final Uri signupUrl = Uri.https(apiUrl, '/api/login/new');
final Uri scoreboardUrl = Uri.https(apiUrl, '/api/scoreboard');
final Uri editionUrl = Uri.https(apiUrl, '/api/edition');