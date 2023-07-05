import 'package:flutter/material.dart';
import 'package:pudim_douro/widgets/side_menu.dart';

const List<String> competitors = ['Tia', 'Mãe', 'Ton', 'Ninho', 'Anne'];

class Vote extends StatelessWidget {
  const Vote({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: const SideMenu(),
      appBar: AppBar(
        title: const Text('Voto'),
      ),
      body: Center(
        child: Container(
          color: Colors.black45,
          padding: const EdgeInsets.symmetric(
            vertical: 50,
            horizontal: 15,
          ),
          height: MediaQuery.of(context).size.height / 1.5,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              const CompetitorDropdown(),
              const CompetitorDropdown(),
              const CompetitorDropdown(),
              ElevatedButton(
                onPressed: () {
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(content: Text('Enviando')),
                  );
                },
                child: const Text('Submit'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class CompetitorDropdown extends StatefulWidget {
  const CompetitorDropdown({super.key});

  @override
  State<CompetitorDropdown> createState() => _CompetitorDropdownState();
}

class _CompetitorDropdownState extends State<CompetitorDropdown> {
  String dropdownValue = competitors.first;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: MediaQuery.of(context).size.width / 1.5,
      child: DropdownButton(
        value: dropdownValue,
        onChanged: (String? value) {
          setState(() {
            dropdownValue = value!;
          });
        },
        items: competitors
            .map((String value) => DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                ))
            .toList(),
      ),
    );
  }
}
