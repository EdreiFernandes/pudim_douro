import 'package:flutter/material.dart';

class SignedUpWarning extends StatelessWidget {
  final bool signedUp = true;
  
  const SignedUpWarning({super.key});

  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: Padding(
        padding: const EdgeInsets.all(10),
        child: getWarningMessage(),
      ),
      onTap: () {
        if(!signedUp) showConfirmDialog(context);
      },
    );
  }

  Container getWarningMessage() {
    Color color = Colors.red;
    String message = 'As inscrições para a próxima competição estão abertas! Gostaria de se inscrever?';
    if(signedUp){
      color = Colors.green;
      message = 'Você já esta inscrito na próxima competição!';
    }

    Container warning = Container(
        padding: const EdgeInsets.all(10),
        color: color,
        child: Text(message),
      );

    return warning;
  }

  Future<dynamic> showConfirmDialog(BuildContext context) {
    return showDialog(
      context: context,
      builder: (BuildContext context) => AlertDialog(
        title: const Text("Inscrição"),
        content: const Text("Confirmar inscrição na competição de 2024?"),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context, 'Cancel'),
            child: const Text("Não"),
          ),
          TextButton(
            onPressed: () => Navigator.pop(context, 'OK'),
            child: const Text("Sim"),
          ),
        ],
      ),
    );
  }
}
