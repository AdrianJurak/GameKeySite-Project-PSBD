INSERT INTO publisher (name, info, date_of_establishment) VALUE
    ('CD Projekt Red', 'CD Projekt Red (zapisywane jako CD PROJEKT RED) –
polski producent gier komputerowych, założony w 2002 roku
,Od września 2003 zespół odpowiedzialny za tworzenie gier rozpoczął prace nad pierwszym projektem –
komputerową grą fabularną Wiedźmin. Po premierze w 2007 roku stała się ona najczęściej kupowaną grą w Polsce',
     '2002-06-03'),
    ('Rockstar Games', 'rupa przedsiębiorstw produkujących gry komputerowe założona w 1998 przez wydawcę
    Take-Two Interactive.', '1998-12-10');

INSERT INTO game (publisher_id, name, short_description, description, price, creation_date, release_date, genre,
                  platform) VALUE
-- CD Projekt Red
    (1, 'Cyberpunk 2077', 'Futurystyczne RPG akcji',
     'Cyberpunk 2077 to gra RPG akcji osadzona w otwartym świecie Night City, z rozbudowaną fabułą i nieliniową narracją.',
     199.99, '2025-04-01', '2020-12-10', 'RPG', 'PC'),
    (1, 'Wiedźmin 3: Dziki Gon', 'Epickie RPG fantasy',
     'Wiedźmin 3 to gra RPG osadzona w świecie fantasy, oparta na prozie Andrzeja Sapkowskiego. Gracz wciela się w Geralta z Rivii.',
     159.99, '2025-04-01', '2015-05-19', 'RPG', 'PC'),

-- Rockstar Games
    (2, 'Grand Theft Auto V', 'Otwarte miasto, przestępczy świat',
     'GTA V to przygodowa gra akcji osadzona w fikcyjnym stanie San Andreas, oferująca otwarty świat i trzech grywalnych bohaterów.',
     149.99, '2025-04-01', '2013-09-17', 'ACTION', 'PC'),
    (2, 'Red Dead Redemption 2', 'Dziki Zachód, epicka opowieść',
     'Red Dead Redemption 2 to gra akcji z otwartym światem, osadzona w realiach Dzikiego Zachodu, z głęboką fabułą i realistycznym światem.',
     189.99, '2025-04-01', '2018-10-26', 'ACTION', 'PC');

INSERT INTO review (game_id, user_name, stars, opinion) VALUE
    (1, 'bogdan', 4, 'fajna gra, cool ;)');
