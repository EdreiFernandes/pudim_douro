import 'package:http/http.dart';
import 'package:http_interceptor/http_interceptor.dart';
import 'package:pudim_douro/http/interceptors/logging_interceptor.dart';

final Client client = InterceptedClient.build(interceptors: [
  LoggingInterceptor(),
]);

const String apiUrl = '192.168.15.150:8080';

final Uri userUrl = Uri.http(apiUrl, '/api/user');
final Uri signupUrl = Uri.http(apiUrl, '/api/login/new');