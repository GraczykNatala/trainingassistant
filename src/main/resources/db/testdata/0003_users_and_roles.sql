insert into
    users (email, password)
values
    ('adminpass', '{noop}adminpass'),
    ('user@example.com', '{noop}userpass'),
    ('editor@example.com', '{noop}editorpass');

insert into
    user_role (name, description)
values
    ('ADMIN', 'pełne uprawnienia'),   -- 1
    ('USER', 'podstawowe uprawnienia, możliwość oddawania głosów'),   -- 2
    ('EDITOR', 'podstawowe uprawnienia + możliwość zarządzania treściami');   -- 3

insert into
    user_roles (user_id, role_id)
values
    (1, 1),
    (2, 2),
    (3, 3);