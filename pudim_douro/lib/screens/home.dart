import 'dart:convert';
import 'dart:typed_data';

import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Pudim DOuro'),
        actions: const <Widget>[],
      ),
      body: ListView(
        children: [
          Column(
            children: [
              Container(
                margin: const EdgeInsets.symmetric(
                  horizontal: 50,
                  vertical: 15,
                ),
                child: const Image(
                  image: AssetImage('assets/images/logo_pudim.png'),
                ),
              ),
            ],
          ),
          const ScoreTable(),
        ],
      ),
    );
  }
}

List<dynamic> tableRows = [
  {
    'name': 'Solange',
    'gold': 1,
    'silver': 1,
    'brass': 1,
  },
  {
    'name': 'Wellington',
    'gold': 0,
    'silver': 2,
    'brass': 4,
  },
  {
    'name': 'Guga',
    'gold': 0,
    'silver': 0,
    'brass': 10,
  },
];

class ScoreTable extends StatelessWidget {
  const ScoreTable({super.key});

  @override
  Widget build(BuildContext context) {
    Base64Decoder base64 = const Base64Decoder();

    Uint8List goldImage = base64.convert(
        "PHN2ZyB3aWR0aD0iMTYiIGhlaWdodD0iMTYiIHJvbGU9ImltZyIgdmlld0JveD0iMCAwIDE2IDE2IiBmaWxsPSJub25lIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8ZyBvcGFjaXR5PSIwLjkiPgo8bWFzayBpZD0icGF0aC0xLWluc2lkZS0xIiBmaWxsPSJ3aGl0ZSI+CjxwYXRoIGQ9Ik04IDBDMy42IDAgMCAzLjYgMCA4QzAgMTIuNCAzLjYgMTYgOCAxNkMxMi40IDE2IDE2IDEyLjQgMTYgOEMxNiAzLjYgMTIuNCAwIDggMFoiLz4KPC9tYXNrPgo8cGF0aCBkPSJNOCAtMkMyLjQ5NTQzIC0yIC0yIDIuNDk1NDMgLTIgOEgyQzIgNC43MDQ1NyA0LjcwNDU3IDIgOCAyVi0yWk0tMiA4Qy0yIDEzLjUwNDYgMi40OTU0MyAxOCA4IDE4VjE0QzQuNzA0NTcgMTQgMiAxMS4yOTU0IDIgOEgtMlpNOCAxOEMxMy41MDQ2IDE4IDE4IDEzLjUwNDYgMTggOEgxNEMxNCAxMS4yOTU0IDExLjI5NTQgMTQgOCAxNFYxOFpNMTggOEMxOCAyLjQ5NTQzIDEzLjUwNDYgLTIgOCAtMlYyQzExLjI5NTQgMiAxNCA0LjcwNDU3IDE0IDhIMThaIiBmaWxsPSIjRjlBQjAwIiBtYXNrPSJ1cmwoI3BhdGgtMS1pbnNpZGUtMSkiLz4KPHBhdGggZD0iTTkuMjQ4MDUgMTJINy41NTQ2OVY1LjQ3MjY2TDUuNTMzMiA2LjA5OTYxVjQuNzIyNjZMOS4wNjY0MSAzLjQ1NzAzSDkuMjQ4MDVWMTJaIiBmaWxsPSIjRThFQUVEIi8+CjwvZz4KPC9zdmc+Cg==");
    Uint8List silverImage = base64.convert(
        "PHN2ZyB3aWR0aD0iMTYiIGhlaWdodD0iMTYiIHJvbGU9ImltZyIgdmlld0JveD0iMCAwIDE2IDE2IiBmaWxsPSJub25lIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8bWFzayBpZD0icGF0aC0xLWluc2lkZS0xIiBmaWxsPSJ3aGl0ZSI+CjxwYXRoIGQ9Ik04IDBDMy42IDAgMCAzLjYgMCA4QzAgMTIuNCAzLjYgMTYgOCAxNkMxMi40IDE2IDE2IDEyLjQgMTYgOEMxNiAzLjYgMTIuNCAwIDggMFoiLz4KPC9tYXNrPgo8cGF0aCBkPSJNOCAtMkMyLjQ5NTQzIC0yIC0yIDIuNDk1NDMgLTIgOEgyQzIgNC43MDQ1NyA0LjcwNDU3IDIgOCAyVi0yWk0tMiA4Qy0yIDEzLjUwNDYgMi40OTU0MyAxOCA4IDE4VjE0QzQuNzA0NTcgMTQgMiAxMS4yOTU0IDIgOEgtMlpNOCAxOEMxMy41MDQ2IDE4IDE4IDEzLjUwNDYgMTggOEgxNEMxNCAxMS4yOTU0IDExLjI5NTQgMTQgOCAxNFYxOFpNMTggOEMxOCAyLjQ5NTQzIDEzLjUwNDYgLTIgOCAtMlYyQzExLjI5NTQgMiAxNCA0LjcwNDU3IDE0IDhIMThaIiBmaWxsPSIjODA4NjhCIiBtYXNrPSJ1cmwoI3BhdGgtMS1pbnNpZGUtMSkiLz4KPHBhdGggZD0iTTEwLjk4MjQgMTJINS4xMzQ3N1YxMC44Mzk4TDcuODk0NTMgNy44OTg0NEM4LjI3MzQ0IDcuNDg0MzggOC41NTI3MyA3LjEyMzA1IDguNzMyNDIgNi44MTQ0NUM4LjkxNjAyIDYuNTA1ODYgOS4wMDc4MSA2LjIxMjg5IDkuMDA3ODEgNS45MzU1NUM5LjAwNzgxIDUuNTU2NjQgOC45MTIxMSA1LjI1OTc3IDguNzIwNyA1LjA0NDkyQzguNTI5MyA0LjgyNjE3IDguMjU1ODYgNC43MTY4IDcuOTAwMzkgNC43MTY4QzcuNTE3NTggNC43MTY4IDcuMjE0ODQgNC44NDk2MSA2Ljk5MjE5IDUuMTE1MjNDNi43NzM0NCA1LjM3Njk1IDYuNjY0MDYgNS43MjI2NiA2LjY2NDA2IDYuMTUyMzRINC45NjQ4NEM0Ljk2NDg0IDUuNjMyODEgNS4wODc4OSA1LjE1ODIgNS4zMzM5OCA0LjcyODUyQzUuNTgzOTggNC4yOTg4MyA1LjkzNTU1IDMuOTYyODkgNi4zODg2NyAzLjcyMDdDNi44NDE4IDMuNDc0NjEgNy4zNTU0NyAzLjM1MTU2IDcuOTI5NjkgMy4zNTE1NkM4LjgwODU5IDMuMzUxNTYgOS40OTAyMyAzLjU2MjUgOS45NzQ2MSAzLjk4NDM4QzEwLjQ2MjkgNC40MDYyNSAxMC43MDcgNS4wMDE5NSAxMC43MDcgNS43NzE0OEMxMC43MDcgNi4xOTMzNiAxMC41OTc3IDYuNjIzMDUgMTAuMzc4OSA3LjA2MDU1QzEwLjE2MDIgNy40OTgwNSA5Ljc4NTE2IDguMDA3ODEgOS4yNTM5MSA4LjU4OTg0TDcuMzE0NDUgMTAuNjM0OEgxMC45ODI0VjEyWiIgZmlsbD0iI0U4RUFFRCIvPgo8L3N2Zz4K");
    Uint8List brassImage = base64.convert(
        "PHN2ZyB3aWR0aD0iMTYiIGhlaWdodD0iMTYiIHJvbGU9ImltZyIgdmlld0JveD0iMCAwIDE2IDE2IiBmaWxsPSJub25lIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8bWFzayBpZD0icGF0aC0xLWluc2lkZS0xIiBmaWxsPSJ3aGl0ZSI+CjxwYXRoIGQ9Ik04IDBDMy42IDAgMCAzLjYgMCA4QzAgMTIuNCAzLjYgMTYgOCAxNkMxMi40IDE2IDE2IDEyLjQgMTYgOEMxNiAzLjYgMTIuNCAwIDggMFoiLz4KPC9tYXNrPgo8cGF0aCBkPSJNOCAtMkMyLjQ5NTQzIC0yIC0yIDIuNDk1NDMgLTIgOEgyQzIgNC43MDQ1NyA0LjcwNDU3IDIgOCAyVi0yWk0tMiA4Qy0yIDEzLjUwNDYgMi40OTU0MyAxOCA4IDE4VjE0QzQuNzA0NTcgMTQgMiAxMS4yOTU0IDIgOEgtMlpNOCAxOEMxMy41MDQ2IDE4IDE4IDEzLjUwNDYgMTggOEgxNEMxNCAxMS4yOTU0IDExLjI5NTQgMTQgOCAxNFYxOFpNMTggOEMxOCAyLjQ5NTQzIDEzLjUwNDYgLTIgOCAtMlYyQzExLjI5NTQgMiAxNCA0LjcwNDU3IDE0IDhIMThaIiBmaWxsPSIjQTc2ODBDIiBtYXNrPSJ1cmwoI3BhdGgtMS1pbnNpZGUtMSkiLz4KPHBhdGggZD0iTTYuODU3NDIgNi45ODQzOEg3Ljc1OTc3QzguMTg5NDUgNi45ODQzOCA4LjUwNzgxIDYuODc2OTUgOC43MTQ4NCA2LjY2MjExQzguOTIxODggNi40NDcyNyA5LjAyNTM5IDYuMTYyMTEgOS4wMjUzOSA1LjgwNjY0QzkuMDI1MzkgNS40NjI4OSA4LjkyMTg4IDUuMTk1MzEgOC43MTQ4NCA1LjAwMzkxQzguNTExNzIgNC44MTI1IDguMjMwNDcgNC43MTY4IDcuODcxMDkgNC43MTY4QzcuNTQ2ODggNC43MTY4IDcuMjc1MzkgNC44MDY2NCA3LjA1NjY0IDQuOTg2MzNDNi44Mzc4OSA1LjE2MjExIDYuNzI4NTIgNS4zOTI1OCA2LjcyODUyIDUuNjc3NzNINS4wMzUxNkM1LjAzNTE2IDUuMjMyNDIgNS4xNTQzIDQuODMzOTggNS4zOTI1OCA0LjQ4MjQyQzUuNjM0NzcgNC4xMjY5NSA1Ljk3MDcgMy44NDk2MSA2LjQwMDM5IDMuNjUwMzlDNi44MzM5OCAzLjQ1MTE3IDcuMzEwNTUgMy4zNTE1NiA3LjgzMDA4IDMuMzUxNTZDOC43MzI0MiAzLjM1MTU2IDkuNDM5NDUgMy41NjgzNiA5Ljk1MTE3IDQuMDAxOTVDMTAuNDYyOSA0LjQzMTY0IDEwLjcxODggNS4wMjUzOSAxMC43MTg4IDUuNzgzMkMxMC43MTg4IDYuMTczODMgMTAuNTk5NiA2LjUzMzIgMTAuMzYxMyA2Ljg2MTMzQzEwLjEyMyA3LjE4OTQ1IDkuODEwNTUgNy40NDE0MSA5LjQyMzgzIDcuNjE3MTlDOS45MDQzIDcuNzg5MDYgMTAuMjYxNyA4LjA0Njg4IDEwLjQ5NjEgOC4zOTA2MkMxMC43MzQ0IDguNzM0MzggMTAuODUzNSA5LjE0MDYyIDEwLjg1MzUgOS42MDkzOEMxMC44NTM1IDEwLjM2NzIgMTAuNTc2MiAxMC45NzQ2IDEwLjAyMTUgMTEuNDMxNkM5LjQ3MDcgMTEuODg4NyA4Ljc0MDIzIDEyLjExNzIgNy44MzAwOCAxMi4xMTcyQzYuOTc4NTIgMTIuMTE3MiA2LjI4MTI1IDExLjg5MjYgNS43MzgyOCAxMS40NDM0QzUuMTk5MjIgMTAuOTk0MSA0LjkyOTY5IDEwLjQwMDQgNC45Mjk2OSA5LjY2MjExSDYuNjIzMDVDNi42MjMwNSA5Ljk4MjQyIDYuNzQyMTkgMTAuMjQ0MSA2Ljk4MDQ3IDEwLjQ0NzNDNy4yMjI2NiAxMC42NTA0IDcuNTE5NTMgMTAuNzUyIDcuODcxMDkgMTAuNzUyQzguMjczNDQgMTAuNzUyIDguNTg3ODkgMTAuNjQ2NSA4LjgxNDQ1IDEwLjQzNTVDOS4wNDQ5MiAxMC4yMjA3IDkuMTYwMTYgOS45Mzc1IDkuMTYwMTYgOS41ODU5NEM5LjE2MDE2IDguNzM0MzggOC42OTE0MSA4LjMwODU5IDcuNzUzOTEgOC4zMDg1OUg2Ljg1NzQyVjYuOTg0MzhaIiBmaWxsPSIjRThFQUVEIi8+Cjwvc3ZnPgo=");
    Uint8List totalImage = base64.convert(
        "PHN2ZyB3aWR0aD0iMTYiIGhlaWdodD0iMTYiIHJvbGU9ImltZyIgdmlld0JveD0iMCAwIDE2IDE2IiBmaWxsPSJub25lIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8cGF0aCBkPSJNOC4wMDAwMSAwQzYuMDQ0NDYgMCA0LjQ0NDQ2IDEuNiA0LjQ0NDQ2IDMuNTU1NTZDNC40NDQ0NiA1LjUxMTExIDYuMDQ0NDYgNy4xMTExMSA4LjAwMDAxIDcuMTExMTFDOS45NTU1NyA3LjExMTExIDExLjU1NTYgNS41MTExMSAxMS41NTU2IDMuNTU1NTZDMTEuNTU1NiAxLjYgOS45NTU1NyAwIDguMDAwMDEgMCIgZmlsbD0iI0Y5QUIwMCIvPgo8cGF0aCBkPSJNMy41NTU1NiA4Ljg4ODkyQzEuNiA4Ljg4ODkyIDAgMTAuNDg4OSAwIDEyLjQ0NDVDMCAxNC40IDEuNiAxNiAzLjU1NTU2IDE2QzUuNTExMTEgMTYgNy4xMTExMSAxNC40IDcuMTExMTEgMTIuNDQ0NUM3LjExMTExIDEwLjQ4ODkgNS41MTExMSA4Ljg4ODkyIDMuNTU1NTYgOC44ODg5MiIgZmlsbD0iIzgwODY4QiIvPgo8cGF0aCBkPSJNMTIuNDQ0NSA4Ljg4ODkyQzEwLjQ4ODkgOC44ODg5MiA4Ljg4ODkyIDEwLjQ4ODkgOC44ODg5MiAxMi40NDQ1QzguODg4OTIgMTQuNCAxMC40ODg5IDE2IDEyLjQ0NDUgMTZDMTQuNCAxNiAxNiAxNC40IDE2IDEyLjQ0NDVDMTYgMTAuNDg4OSAxNC40IDguODg4OTIgMTIuNDQ0NSA4Ljg4ODkyIiBmaWxsPSIjQTc2ODBDIi8+Cjwvc3ZnPgo=");

    return Center(
      child: DataTable(
        columnSpacing: MediaQuery.of(context).size.width / 8,
        border: TableBorder.all(),
        columns: <DataColumn>[
          const DataColumn(
            label: Expanded(
              child: Text(
                'Nome',
              ),
            ),
          ),
          DataColumn(
            label: Expanded(
              child: SvgPicture.memory(goldImage),
            ),
          ),
          DataColumn(
            label: Expanded(
              child: SvgPicture.memory(silverImage),
            ),
          ),
          DataColumn(
            label: Expanded(
              child: SvgPicture.memory(brassImage),
            ),
          ),
          DataColumn(
            label: Expanded(
              child: SvgPicture.memory(totalImage),
            ),
          ),
        ],
        rows: tableRows
            .map(
              (value) => DataRow(cells: [
                DataCell(Text(value['name'])),
                DataCell(Text(value['gold'].toString())),
                DataCell(Text(value['silver'].toString())),
                DataCell(Text(value['brass'].toString())),
                DataCell(Text((value['gold'] + value['silver'] + value['brass'])
                    .toString())),
              ]),
            )
            .toList(),
      ),
    );
  }
}
