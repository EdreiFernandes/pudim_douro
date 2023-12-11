class ScoreboardLine {
  final String id;
  final String user;
  final String goldMedal;
  final String silverMedal;
  final String brassMedal;

  ScoreboardLine(
    this.id,
    this.user,
    this.goldMedal,
    this.silverMedal,
    this.brassMedal,
  );

  ScoreboardLine.fromJson(Map<String, dynamic> json)
      : id = json['id'],
        user = json['user_profile'],
        goldMedal = json['gold_medal'],
        silverMedal = json['silver_medal'],
        brassMedal = json['brass_medal'];
}
